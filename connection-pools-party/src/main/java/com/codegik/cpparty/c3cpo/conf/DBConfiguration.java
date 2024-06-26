package com.codegik.cpparty.c3cpo.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {


    @Bean("dataSource")
    public ComboPooledDataSource get3cp0DataSource(){
        System.out.println("New 3cp0 DataSource requested...");
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        cpds.setUser("root");
        cpds.setPassword("pass");
        return cpds;
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        System.out.println("New TXManager requested...");
        return new DataSourceTransactionManager(dataSource);
    }
}
