package com.learn.spl.config;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;

/**
 * @author created by zzz at 2019/12/3 16:42
 */
@EnableTransactionManagement
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource h2PooledDataSource(DataSource h2DataSource) {
        return JdbcConnectionPool.create((ConnectionPoolDataSource) h2DataSource);
    }

    @Bean
    public DataSource h2DataSource() {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setUrl("jdbc:h2:~/test");
        jdbcDataSource.setUser("sa");
        jdbcDataSource.setPassword("sa");
        return jdbcDataSource;
    }

    @Bean
    public DataSource switchDataSource(DataSource dataSource) {
        return new DelegatingDataSource(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource h2DataSource) {
        return new DataSourceTransactionManager(h2DataSource);
    }
}
