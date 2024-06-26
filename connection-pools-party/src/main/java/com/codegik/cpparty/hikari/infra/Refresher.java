package com.codegik.cpparty.hikari.infra;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Component
public class Refresher implements ApplicationContextAware {

    ApplicationContext ctx;

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private DataSource ds;

    public void refresh() {
        HikariDataSource hikariDataSource = (HikariDataSource) ds;

        System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);

        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("pass");
        hikariDataSource.getHikariPoolMXBean().softEvictConnections();

        System.out.println("Connection soft evicted!");
        System.out.println("Connection refreshed!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}