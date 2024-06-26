package com.codegik.cpparty.c3cpo.infra;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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

    public void refresh() throws Exception {
        ComboPooledDataSource dataSource = (ComboPooledDataSource) ds;

        System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);

        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3325/person");
        dataSource.softReset("root","pass");

        System.out.println("Connection soft evicted!");
    }

    public void refresh(String user, String passwd) throws Exception {
        ComboPooledDataSource dataSource = (ComboPooledDataSource) ds;

        System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);

        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3325/person");
        dataSource.softReset(user,passwd);

        System.out.println("Connection soft evicted!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
