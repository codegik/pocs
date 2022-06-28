package com.codegik.h2.h2hive.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class H2DataSource {

    @Value("${URL}")
    private String url;

    @Value("${USERNAME}")
    private String username;

    @Value("${PASSWORD}")
    private String password;

    @Value("${DRIVER}")
    private String driver;

    private Connection connection;


    public Connection connection() throws SQLException, IOException {
        if (connection == null) {
            connection = createDataSource().getConnection();

            for (String script: Arrays.asList("./schema.sql", "./data.sql")) {
                final String sql = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(script).getPath())));
                connection.createStatement().executeUpdate(sql);
            }

        } else if (connection.isClosed()) {
            connection = createDataSource().getConnection();
        }

        return connection;
    }


    private DataSource createDataSource() {
        final PoolProperties properties = new PoolProperties();
        properties.setUrl(url);
        properties.setDriverClassName(driver);
        properties.setUsername(username);
        properties.setPassword(password);
        properties.setJmxEnabled(true);
        properties.setTestWhileIdle(true);
        properties.setTestOnBorrow(true);
        properties.setValidationQuery("SELECT 1");
        properties.setTestOnReturn(false);
        properties.setValidationInterval(1000);
        properties.setValidationQueryTimeout(3);
        properties.setTimeBetweenEvictionRunsMillis(30000);
        properties.setMaxActive(1);
        properties.setMinIdle(1);
        properties.setInitialSize(1);
        properties.setMaxWait(10000);
        properties.setRemoveAbandonedTimeout(21600);
        properties.setMinEvictableIdleTimeMillis(30000);
        properties.setLogAbandoned(true);
        properties.setRemoveAbandoned(true);

        return new DataSource(properties);
    }
}
