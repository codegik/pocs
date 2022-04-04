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
public class TransactionsDao {
    private static final Logger logger = LoggerFactory.getLogger(TransactionsDao.class);

    @Autowired
    private H2DataSource h2DataSource;

    private String getQuery() {
        return "WITH fed_returns AS " +
                "(SELECT " +
                "   t1.tw_seq_nbr, " +
                "   CAST(SUBSTR(t1.tw_ach_rec_data, 14, 7) as BIGINT) AS last_trace_nbr, " +
                "   t1.tw_batch_seq, " +
                "   t1.tw_ach_comp_id, " +
                "   t1.tw_ach_rec_trace, " +
                "   t1.tw_rej_reason, " +
                "   t1.tw_post_dt, " +
                "   t1.tw_proc_dt, " +
                "   REPLACE(LOWER(SUBSTR(t1.tw_ach_rec_data, 2, 7)), '  ', ' ') acct_name, " +
                "   RTRIM(LTRIM(SUBSTR(t1.tw_ach_rec_data, 30, 5))) ach_amt, " +
                "FROM misdb.tran_warehouse t1 " +
                "WHERE t1.tw_proc_dt = DATE(?)) " +
                "" +
                "SELECT * from fed_returns";
    }


    public Transaction getObject(ResultSet resultSet) throws SQLException {
        final Transaction transaction = new Transaction();
        transaction.setTw_seq_nbr(resultSet.getString(1));
        transaction.setTw_ach_rec_data(resultSet.getString(2));
        transaction.setTw_batch_seq(resultSet.getString(3));
        transaction.setTw_ach_comp_id(resultSet.getString(4));
        transaction.setTw_ach_rec_trace(resultSet.getString(5));
        transaction.setTw_rej_reason(resultSet.getString(6));
        transaction.setTw_post_dt(resultSet.getDate(7));
        transaction.setTw_proc_dt(resultSet.getDate(8));
        transaction.setAcct_name(resultSet.getString(9));
        transaction.setAch_amt(resultSet.getString(10));
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
