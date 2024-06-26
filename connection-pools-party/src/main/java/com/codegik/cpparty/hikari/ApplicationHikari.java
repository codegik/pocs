package com.codegik.cpparty.hikari;

import com.codegik.cpparty.hikari.dao.DBLoader;
import com.codegik.cpparty.hikari.infra.Refresher;
import com.zaxxer.hikari.HikariDataSource;
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
public class ApplicationHikari {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationHikari.class, args);
    }

    @Autowired
    DBLoader loder;

    @Autowired
    DataSource dataSource;

    @Autowired
    Refresher refresher;


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Spring Boot 3.3.0 up and running! ");
            loder.insertData();
            System.out.println("DB Loader done. ");
            HikariDataSource hikariDataSource = (HikariDataSource) dataSource;

            reusingConnectionsHikari(hikariDataSource, refresher);
            System.exit(0);
        };
    }

    private void reusingConnectionsHikari(HikariDataSource hikariDataSource, Refresher refresher) throws Exception {
        List<Connection> connectionList = new ArrayList<>();
        List<String> firstIdList = new ArrayList<>();
        List<String> secondIdList = new ArrayList<>();
        int poolSize = 10;

        hikariDataSource.getHikariConfigMXBean().setMaximumPoolSize(poolSize);

        System.out.println("Initial state pool");
        traceDataSource(hikariDataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = hikariDataSource.getConnection();
            firstIdList.add(extractObjectInstanceId(conn));
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }
        connectionList.clear();

        System.out.println("First ID list: " + firstIdList);
        traceDataSource(hikariDataSource);

        refresher.refresh();

        System.out.println("Connections refreshed");
        traceDataSource(hikariDataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = hikariDataSource.getConnection();
            secondIdList.add(extractObjectInstanceId(conn));
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }
        connectionList.clear();

        System.out.println("Second ID list: " + secondIdList);
        traceDataSource(hikariDataSource);

        for (String id : firstIdList) {
            assert(secondIdList.contains(id)); // all ids must be equals
        }
    }

    private String extractObjectInstanceId(Connection conn) {
        return conn.toString().split("@")[2];
    }

    private void traceDataSource(HikariDataSource dataSource) {
        System.out.println("Pool size: " + dataSource.getHikariConfigMXBean().getMaximumPoolSize());
        System.out.println("Active connections: " + dataSource.getHikariPoolMXBean().getActiveConnections());
        System.out.println("Idle connections: " + dataSource.getHikariPoolMXBean().getIdleConnections());
        System.out.println("Total connections: " + dataSource.getHikariPoolMXBean().getTotalConnections());
    }
}
