package com.aaron.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.util.Properties;

/**
 * Created by com.aaron on 7/11/17.
 */
@Configuration
@MapperScan(basePackages = "com.com.aaron.dao", sqlSessionFactoryRef = "mybatisSesstionFactory")
public class MyBatisConfiguration {
    @Value("${spring.datasource.serverurl}")
    private String serverurl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.hibernate.dialect}")
    private String dialect;
    @Value("${spring.hibernate.show_sql}")
    private String showSql;
    @Value("${spring.hibernate.autoReconnect}")
    private String autoReconnect;
    @Value("${spring.hibernate.transaction.auto_close_session}")
    private String transactionAutoClostSession;
    @Value("${spring.hibernate.connection.autocommit}")
    private String connectionAutoCommit;
    @Value("${spring.statement_cache.size}")
    private String statementCacheSize;
    @Value("${spring.hibernate.packagesToScan}")
    private String packagesToScan;

    @Bean
    @Qualifier(value = "mybatisDataSource")
    public DataSource mybatisDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(serverurl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setValidationQuery(validationQuery);
        //druidDataSource.setFilters(filters);
        return druidDataSource;
    }

    @Bean
    @Qualifier(value = "mybatisSesstionFactory")
    public SqlSessionFactory mybatisSesstionFactory(@Qualifier("mybatisDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
}
