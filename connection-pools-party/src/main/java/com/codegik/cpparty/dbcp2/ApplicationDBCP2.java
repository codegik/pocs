package com.codegik.cpparty.dbcp2;

import com.codegik.cpparty.dbcp2.conf.DBConfiguration;
import com.codegik.cpparty.dbcp2.dao.DBLoader;
import com.codegik.cpparty.dbcp2.dao.PersonRepository;
import com.codegik.cpparty.dbcp2.infra.Refresher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApplicationDBCP2 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDBCP2.class, args);
    }

    @Autowired
    DBLoader loder;

    @Autowired
    DataSource dataSource;

    @Autowired
    Refresher refresher;

    @Autowired
    PersonRepository personRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Spring Boot 3.3.0 up and running! ");
            loder.insertData();
            System.out.println("DB Loader done. ");

            reusingConnections(dataSource, refresher);
            refreshWithInvalidCredentials(dataSource, refresher);

            System.exit(0);
        };
    }

    private void reusingConnections(DataSource dataSource, Refresher refresher) throws Exception {
        DBConfiguration.PoolingDataSourceExt dbcp2DataSource = (DBConfiguration.PoolingDataSourceExt) dataSource;
        List<Connection> connectionList = new ArrayList<>();
        List<String> firstIdList = new ArrayList<>();
        List<String> secondIdList = new ArrayList<>();
        int poolSize = 10;

        dbcp2DataSource.getPool().setMaxTotal(poolSize);

        System.out.println("Initial state pool");
        traceDataSource(dbcp2DataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = dbcp2DataSource.getConnection();
            firstIdList.add(extractObjectInstanceId(conn));
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }
        connectionList.clear();

        System.out.println("First ID list: " + firstIdList);
        traceDataSource(dbcp2DataSource);

        refresher.refresh();

        System.out.println("Connections refreshed");
        traceDataSource(dbcp2DataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = dbcp2DataSource.getConnection();
            secondIdList.add(extractObjectInstanceId(conn));
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }
        connectionList.clear();

        System.out.println("Second ID list: " + secondIdList);
        traceDataSource(dbcp2DataSource);

        for (String id : firstIdList) {
            assert(secondIdList.contains(id)); // all ids must be equals
        }
    }

    private void refreshWithInvalidCredentials(DataSource dataSource, Refresher refresher) throws Exception {
        DBConfiguration.PoolingDataSourceExt dbcp2DataSource = (DBConfiguration.PoolingDataSourceExt) dataSource;
        List<Connection> connectionList = new ArrayList<>();
        int poolSize = 10;

        dbcp2DataSource.getPool().setMaxTotal(poolSize);

        System.out.println("Initial state pool");
        traceDataSource(dbcp2DataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = dataSource.getConnection();
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }

        traceDataSource(dbcp2DataSource);

        refresher.refresh("invalid-user", "invalid-passwd");

        System.out.println("Requesting new connection will fail");
        try {
            Connection conn = dataSource.getConnection();
        } catch (Exception e) {
            System.out.println("Failing to open new connections");
        }

        traceDataSource(dbcp2DataSource);
    }

    private String extractObjectInstanceId(Connection conn) {
        return conn.toString().split(",")[0];
    }

    private void traceDataSource(DBConfiguration.PoolingDataSourceExt dataSource) {
        System.out.println("Pool size: " + dataSource.getPool().getMaxTotal());
        System.out.println("Active connections: " + dataSource.getPool().getNumActive());
        System.out.println("Idle connections: " + dataSource.getPool().getNumIdle());
        System.out.println("Total connections: " + (dataSource.getPool().getNumActive() + dataSource.getPool().getNumIdle()));
    }
}
