package com.codegik.h2.h2hive.dao;

import com.codegik.h2.h2hive.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChargeBackDao {
    private static final Logger logger = LoggerFactory.getLogger(ChargeBackDao.class);

    @Autowired
    private H2DataSource h2DataSource;

    private String getQuery() {
        return "with fed_returns as\n" +
                "    (select\n" +
                "           cast(substr(t1.tw_ach_rec_data, 14, 7) as bigint) as last_trace_nbr,\n" +
                "           substr(t1.tw_ach_rec_data, 3, 3) return_code,\n" +
                "           t3.tw_seq_nbr,\n" +
                "           replace(lower(substr(t3.tw_ach_rec_data, 54, 22)), '  ', ' ') acct_name,\n" +
                "           rtrim(ltrim(substr(t3.tw_ach_rec_data, 29, 10))) ach_amt,\n" +
                "           t3.tw_batch_seq,\n" +
                "           t3.tw_ach_comp_id,\n" +
                "           t1.tw_ach_rec_trace seven_trace,\n" +
                "           t3.tw_rej_reason,\n" +
                "           t3.tw_post_dt,\n" +
                "           t3.tw_proc_dt\n" +
                "    from misdb.tran_warehouse t1\n" +
                "join  misdb.tran_warehouse t3 on t3.tw_tpr_last_trace = cast((substr(t1.tw_ach_rec_data, 14, 7)) as bigint)\n" +
                "where t1.tw_ach_rec_type = '7'\n" +
                "and substr(t1.tw_ach_rec_data, 1, 3) like '99R%'\n" +
                "and DATE(t1.tw_proc_dt) = DATE(?)),\n" +
                "\n" +
                "  accounts_with_fed_returns as (\n" +
                "select substr(t1.tw_ach_rec_data, 12, 17) acct_nbr,\n" +
                "       rtrim(ltrim(substr(t1.tw_ach_rec_data, 29, 10))) internal_ach_amt,\n" +
                "       fr.ach_amt fed_return_ach_amt,\n" +
                "       fr.return_code,\n" +
                "       t1.tw_rej_reason,\n" +
                "       fr.last_trace_nbr,\n" +
                "       trim(substr(t1.tw_ach_rec_data, 3,9)) routing_nbr,\n" +
                "       fr.tw_seq_nbr ret_seq_nbr,\n" +
                "       t1.tw_seq_nbr tw_seq_nbr,\n" +
                "       fr.acct_name,\n" +
                "       t1.tw_post_dt,\n" +
                "       replace(lower(substr(t1.tw_ach_rec_data, 54, 22)), '  ', ' ') resolved_acct_name,\n" +
                "       tpm.tpm_adj_acct_nbr,\n" +
                "       case\n" +
                "        when rtrim(ltrim(substr(t1.tw_ach_rec_data, 1, 2))) in('22', '32') then\n" +
                "            'DD8'\n" +
                "        else\n" +
                "            'DW8'\n" +
                "       end acct_transaction_code,\n" +
                "       fr.tw_ach_comp_id\n" +
                "from fed_returns fr\n" +
                "left join misdb.tran_warehouse t1 on t1.tw_ach_rec_type = '6'\n" +
                "                                        and t1.tw_batch_seq = fr.tw_batch_seq\n" +
                "                                        and t1.tw_seq_nbr = (fr.tw_seq_nbr+(case when fr.tw_ach_comp_id = '2110750860' then 2 else 1 end))\n" +
                "                                        and rtrim(ltrim(substr(t1.tw_ach_rec_data, 29, 10))) = fr.ach_amt\n" +
                "left join misdb.third_party_mast tpm on tpm.tpm_co_id = t1.tw_ach_comp_id\n" +
                "where  fr.tw_ach_comp_id in ('4384081623', '1900000001', '2110750860', '4042960120', '9211075086')),\n" +
                "accounts_with_internal_returns as (select trim(substr(t1.tw_ach_rec_data, 12, 17)) acct_nbr,\n" +
                "       t1.tw_seq_nbr,\n" +
                "       rtrim(ltrim(substr(t1.tw_ach_rec_data, 29, 10))) ach_amt,\n" +
                "        concat('R',case when t1.tw_orig_rej_rsn < 10 then concat('0', cast(t1.tw_orig_rej_rsn as CHAR(1)))\n" +
                "           else cast(t1.tw_orig_rej_rsn as CHAR(2))end) return_code,\n" +
                "              trim(substr(t1.tw_ach_rec_data, 54, 22)) resolved_acct_name,\n" +
                "        case\n" +
                "            when rtrim(ltrim(substr(t1.tw_ach_rec_data, 1, 2))) in('22', '32') then\n" +
                "             'DD8'\n" +
                "            else\n" +
                "              'DW8'\n" +
                "            end acct_transaction_code,\n" +
                "       t1.tw_post_dt,\n" +
                "       t1.tw_tpr_last_trace,\n" +
                "       t1.tw_ach_comp_id,\n" +
                "       t1.tw_origin,\n" +
                "       'ORIGIN_REJECTION' source_of_rejection\n" +
                "from misdb.tran_warehouse t1\n" +
                "where t1.tw_ach_rec_type = '6'\n" +
                "and (t1.tw_orig_rej_rsn != 0 or t1.tw_rej_reason != 0)\n" +
                "and DATE(t1.tw_tpr_last_date) = DATE(?)),\n" +
                "all_returns as(\n" +
                "select acct_nbr,fed_return_ach_amt, return_code, last_trace_nbr, tw_seq_nbr, acct_name, tw_post_dt, acct_transaction_code, tw_ach_comp_id, 2 tw_origin, 'FED_RET' as source_of_return\n" +
                "from accounts_with_fed_returns fr\n" +
                "union\n" +
                "select acct_nbr, ach_amt, return_code, tw_tpr_last_trace, tw_seq_nbr, resolved_acct_name, tw_post_dt, acct_transaction_code, tw_ach_comp_id, tw_origin, 'ORIGIN_RET' as source_of_return\n" +
                "from accounts_with_internal_returns)\n" +
                "\n" +
                "select distinct trim(ar.acct_nbr),\n" +
                "       ar.fed_return_ach_amt,\n" +
                "       ar.return_code,\n" +
                "       ar.last_trace_nbr,\n" +
                "       ar.tw_seq_nbr ach_seq_id,\n" +
                "       upper(acct_name) acct_name,\n" +
                "       ar.tw_post_dt,\n" +
                "       ar.acct_transaction_code,\n" +
                "       ar.tw_ach_comp_id,\n" +
                "       tpm.tpm_adj_acct_nbr,\n" +
                "       case\n" +
                "           when nda.nd_appl_code is not null then\n" +
                "             nda.nd_appl_code\n" +
                "           when s.s_appl_code is not null then\n" +
                "             s.s_appl_code\n" +
                "           when ln.l_appl_code is not null then\n" +
                "             ln.l_appl_code\n" +
                "        end application_code,\n" +
                "        case\n" +
                "           when nda.nd_opening_dt is not null then\n" +
                "             nda.nd_opening_dt\n" +
                "           when s.s_opening_dt is not null then\n" +
                "             s.s_opening_dt\n" +
                "           when ln.l_dt_first_occur is not null then\n" +
                "             ln.l_dt_first_occur\n" +
                "        end account_opening_date,\n" +
                "        case\n" +
                "           when nda.nd_close_date is not null then\n" +
                "             nda.nd_close_date\n" +
                "           when s.s_close_date is not null then\n" +
                "             s.s_close_date\n" +
                "        end account_close_date,\n" +
                "        case\n" +
                "           when ndh.ndhist_trcd is not null then\n" +
                "             ndh.ndhist_trcd\n" +
                "           when svh.svhist_trcd is not null then\n" +
                "             svh.svhist_trcd\n" +
                "        end acct_posted_trcd_code,\n" +
                "      case\n" +
                "           when nda.nd_appl_code = '10' and\n" +
                "                ((acct_transaction_code = 'DD8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DW8' and source_of_return = 'FED_RET')) then\n" +
                "             'ND_CREDIT'\n" +
                "           when nda.nd_appl_code = '10' and\n" +
                "                ((acct_transaction_code = 'DW8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DD8' and source_of_return = 'FED_RET')) then\n" +
                "             'ND_DEBIT'\n" +
                "           when s.s_appl_code = '00' and\n" +
                "                ((acct_transaction_code = 'DD8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DW8' and source_of_return = 'FED_RET')) then\n" +
                "             'SV_CREDIT'\n" +
                "           when s.s_appl_code = '00' and\n" +
                "                ((acct_transaction_code = 'DW8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DD8' and source_of_return = 'FED_RET')) then\n" +
                "             'SV_DEBIT'\n" +
                "           when s.s_appl_code = '02' and\n" +
                "                ((acct_transaction_code = 'DD8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DW8' and source_of_return = 'FED_RET')) then\n" +
                "             'CD_CREDIT'\n" +
                "           when s.s_appl_code = '02' and\n" +
                "                ((acct_transaction_code = 'DW8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DD8' and source_of_return = 'FED_RET')) then\n" +
                "             'CD_DEBIT'\n" +
                "           when ln.l_appl_code ='51' and\n" +
                "                ((acct_transaction_code = 'DD8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DW8' and source_of_return = 'FED_RET')) then\n" +
                "             'LN_CREDIT'\n" +
                "           when ln.l_appl_code ='51' and\n" +
                "                ((acct_transaction_code = 'DW8' and source_of_return = 'ORIGIN_RET') OR\n" +
                "                (acct_transaction_code = 'DD8' and source_of_return = 'FED_RET')) then\n" +
                "             'LN_DEBIT'\n" +
                "           else\n" +
                "             'Unknown'\n" +
                "        end tx_type,"+
                "        source_of_return\n" +
                "from all_returns ar\n" +
                "left join misdb.nda nda on udf.lcdecrypt(nda.nd_acct_nbr, 'db_npi_key') = trim(ar.acct_nbr)\n" +
                "left join misdb.savings s on udf.lcdecrypt(s.s_acct_nbr, 'db_npi_key') = trim(ar.acct_nbr)\n" +
                "left join misdb.loan ln on udf.lcdecrypt(ln.l_acct_nbr, 'db_npi_key') = trim(ar.acct_nbr)\n" +
                "left join misdb.nd_history ndh on ndh.ndhist_ach_seq_nbr = ar.tw_seq_nbr and ndh.ndhist_trcd in('DD8', 'DW8')\n" +
                "left join misdb.sv_history svh on svh.svhist_ach_seq_nbr = ar.tw_seq_nbr and svh.svhist_trcd in('DD8', 'DW8')\n" +
                "left join misdb.third_party_mast tpm on tpm.tpm_co_id = ar.tw_ach_comp_id";
    }


    public Transaction getObject(ResultSet resultSet) throws SQLException {
        final Transaction transaction = new Transaction();
        transaction.setAcct_nbr(resultSet.getString(1));
        transaction.setFed_return_ach_amt(resultSet.getString(2));
        transaction.setReturn_code(resultSet.getString(3));
        transaction.setLast_trace_nbr(resultSet.getString(4));
        transaction.setAch_seq_id(resultSet.getString(5));
        transaction.setAcct_name(resultSet.getString(6));
        transaction.setTw_post_dt(resultSet.getDate(7));
        transaction.setAcct_transaction_code(resultSet.getString(8));
        transaction.setTw_ach_comp_id(resultSet.getString(9));
        transaction.setTpm_adj_acct_nbr(resultSet.getString(10));
        transaction.setApplication_code(resultSet.getString(11));
        transaction.setAccount_opening_date(resultSet.getDate(12));
        transaction.setAccount_close_date(resultSet.getDate(13));
        transaction.setAcct_posted_trcd_code(resultSet.getString(14));
        transaction.setTx_type(resultSet.getString(15));
        transaction.setSource_of_return(resultSet.getString(15));
        return transaction;
    }


    public List<Transaction> findByDate(String date) {
        final List<Transaction> results = new ArrayList<>();

        try (Connection connection = h2DataSource.connection()) {
            final PreparedStatement preparedStatement = connection.prepareStatement(getQuery());
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, date);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                try {
                    results.add(getObject(resultSet));
                } catch (final Exception e) {
                    logger.error("Error exporting area code record.", e);
                }
            }
        } catch (final Exception e) {
            logger.error("Error while reading the returnsdata.", e);
            throw new RuntimeException("Error reading/adding data from EDH", e);
        }

        return results;
    }
}
