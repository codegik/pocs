package com.codegik.cpparty.hikari.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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
    public DataSource getDataSource(){
        System.out.println("New DataSource requested...");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:mysql://127.0.0.1:3325/person" );
        config.setUsername( "root" );
        config.setPassword( "pass" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        return new HikariDataSource( config );
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        System.out.println("New TXManager requested...");
        return new DataSourceTransactionManager(dataSource);
    }

}
