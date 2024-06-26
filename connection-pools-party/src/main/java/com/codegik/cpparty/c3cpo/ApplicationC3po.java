package com.codegik.cpparty.c3cpo;

import com.codegik.cpparty.c3cpo.dao.DBLoader;
import com.codegik.cpparty.c3cpo.dao.PersonRepository;
import com.codegik.cpparty.c3cpo.infra.Refresher;
import com.codegik.cpparty.c3cpo.model.Person;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApplicationC3po {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationC3po.class, args);
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
            ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) dataSource;
            reusingConnections(comboPooledDataSource, refresher);
            refreshWithInvalidCredentials(comboPooledDataSource, refresher);
            System.exit(0);
        };
    }

    private void reusingConnections(ComboPooledDataSource dataSource, Refresher refresher) throws Exception {
        List<Connection> connectionList = new ArrayList<>();
        List<String> firstIdList = new ArrayList<>();
        List<String> secondIdList = new ArrayList<>();
        int poolSize = 10;

        dataSource.setMaxPoolSize(poolSize);

        System.out.println("Initial state pool");
        traceDataSource(dataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = dataSource.getConnection();
            firstIdList.add(extractObjectInstanceId(conn));
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }
        connectionList.clear();

        System.out.println("First ID list: " + firstIdList);
        traceDataSource(dataSource);

        refresher.refresh();

        System.out.println("Connections refreshed");
        traceDataSource(dataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = dataSource.getConnection();
            secondIdList.add(extractObjectInstanceId(conn));
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }
        connectionList.clear();

        System.out.println("Second ID list: " + secondIdList);
        traceDataSource(dataSource);

        boolean allMatch = firstIdList.containsAll(secondIdList);
        System.out.println("IDs from firstList contains into secondList: " + allMatch);
    }

    private void refreshWithInvalidCredentials(ComboPooledDataSource dataSource, Refresher refresher) throws Exception {
        List<Connection> connectionList = new ArrayList<>();
        int poolSize = 10;

        dataSource.setMaxPoolSize(poolSize);

        System.out.println("Initial state pool");
        traceDataSource(dataSource);

        for (int i = 0; i < poolSize; i++) {
            Connection conn = dataSource.getConnection();
            connectionList.add(conn);
        }

        for (Connection connection : connectionList) {
            connection.close();
        }

        traceDataSource(dataSource);

        try {
            refresher.refresh("invalid-user", "invalid-passwd");
        } catch (Exception e) {
            System.out.println("Refresh is failing");
        }

        System.out.println("Requesting new connection will not fail");
        Connection conn = dataSource.getConnection();
        Iterable<Person> people = personRepository.findAll();
        System.out.println("Able to request data: " + people.iterator().hasNext());

        traceDataSource(dataSource);
    }

    private String extractObjectInstanceId(Connection conn) {
        return conn.toString().split("@")[2];
    }

    private void traceDataSource(ComboPooledDataSource dataSource) throws SQLException {
        System.out.println("Pool size: " + dataSource.getMaxPoolSize());
        System.out.println("Active connections: " + dataSource.getNumBusyConnections());
        System.out.println("Idle connections: " + dataSource.getNumIdleConnections());
        System.out.println("Total connections: " + dataSource.getNumConnections());
    }
}
