package com.codegik.cpparty.dbcp2.infra;

import com.codegik.cpparty.dbcp2.conf.DBConfiguration;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
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
        System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);
        ((DBConfiguration.PoolingDataSourceExt) ds).getPool().evict();
        System.out.println("Connection soft evicted!");
    }

    public void refresh(String user, String passwd) throws Exception {
        DBConfiguration.PoolingDataSourceExt dataSource = (DBConfiguration.PoolingDataSourceExt) ds;

        System.out.println("Refreshing connections... TX manager: " + txManager + " - DS: " + ds);

        dataSource.getPool().clear();
        ((DriverManagerConnectionFactory) ((PoolableConnectionFactory) dataSource.getPool().getFactory()).getConnectionFactory()).getProperties().setProperty("user", user);
        ((DriverManagerConnectionFactory) ((PoolableConnectionFactory) dataSource.getPool().getFactory()).getConnectionFactory()).getProperties().setProperty("password", passwd);

        System.out.println("Connection soft evicted!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

}