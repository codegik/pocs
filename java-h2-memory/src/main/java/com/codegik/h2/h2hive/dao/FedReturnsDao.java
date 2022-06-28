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
public class FedReturnsDao {
    private static final Logger logger = LoggerFactory.getLogger(FedReturnsDao.class);

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
                "and DATE(t1.tw_proc_dt) = DATE(?))\n" +

                "select * from fed_returns\n";
    }


    public Transaction getObject(ResultSet resultSet) throws SQLException {
        final Transaction transaction = new Transaction();
        transaction.setLast_trace_nbr(resultSet.getString(1));
        transaction.setReturn_code(resultSet.getString(2));
        transaction.setTw_post_dt(resultSet.getDate(10));
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
