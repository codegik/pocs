package com.codegik.cpparty.dbcp2.conf;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.EvictionConfig;
import org.apache.commons.pool2.impl.EvictionPolicy;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {


    @Bean("dataSource")
    public PoolingDataSourceExt<PoolableConnection> getDbcpDtaSource() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "pass");

        ConnectionFactory cf = new DriverManagerConnectionFactory("jdbc:mysql://127.0.0.1:3325/person", props);
        PoolableConnectionFactory poolCF =  new PoolableConnectionFactory(cf, null);
        GenericObjectPool<PoolableConnection> connectionPool =  new GenericObjectPool<>(poolCF);
        poolCF.setPool(connectionPool);

        connectionPool.setEvictionPolicy(new EvictionPolicy<PoolableConnection>() {
            @Override
            public boolean evict(EvictionConfig config, PooledObject<PoolableConnection> underTest, int idleCount) {
                if (PooledObjectState.IDLE == underTest.getState() ||
                    PooledObjectState.EVICTION == underTest.getState()){
                    return true;
                }
                return false;
            }
        });

        System.out.println("New DBCP DataSource requested...");
        return new PoolingDataSourceExt<>(connectionPool);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        System.out.println("New TXManager requested...");
        return new DataSourceTransactionManager(dataSource);
    }

    public class PoolingDataSourceExt<C extends Connection>  extends PoolingDataSource<C> {
        public PoolingDataSourceExt(ObjectPool pool) {
            super(pool);
        }

        public GenericObjectPool<C> getPool() {
            return (GenericObjectPool<C>) super.getPool();
        }
    }
}
