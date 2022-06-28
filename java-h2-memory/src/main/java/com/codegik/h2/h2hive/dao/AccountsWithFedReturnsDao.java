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
public class AccountsWithFedReturnsDao {
    private static final Logger logger = LoggerFactory.getLogger(AccountsWithFedReturnsDao.class);

    @Autowired
    private H2DataSource h2DataSource;

    private String getQuery() {
        return  "with fed_returns as\n" +
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
                "where  fr.tw_ach_comp_id in ('4384081623', '1900000001', '2110750860', '4042960120', '9211075086'))\n" +
                "select * from accounts_with_fed_returns";
    }


    public Transaction getObject(ResultSet resultSet) throws SQLException {
        final Transaction transaction = new Transaction();
        transaction.setAcct_nbr(resultSet.getString(1));
        transaction.setFed_return_ach_amt(resultSet.getString(2));
        transaction.setReturn_code(resultSet.getString(3));
        transaction.setLast_trace_nbr(resultSet.getString(4));
        transaction.setAch_seq_id(resultSet.getString(5));
        transaction.setAcct_name(resultSet.getString(6));
        return transaction;
    }


    public List<Transaction> findByDate(String date) {
        final List<Transaction> results = new ArrayList<>();

        try (Connection connection = h2DataSource.connection()) {
            final PreparedStatement preparedStatement = connection.prepareStatement(getQuery());
            preparedStatement.setString(1, date);
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
