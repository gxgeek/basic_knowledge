package com.gxgeek;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author gxgeek
 * @create 2019-06-26 下午2:04
 */
@Slf4j
@Configuration
@MapperScan(value = "com.gxgeek.mapper",sqlSessionFactoryRef = "commonMysqlSessionFactory")
public class AccountMysqlMyatisConfig {

    @Bean("commonMysqlDataSouece")
    public DataSource commonMysqlDataSouece() {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/mybatis");
        properties.setProperty("username", "root");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();
        return dataSource;
    }


    //sqlSession
    @Bean("commonMysqlSessionFactory")
    public SqlSessionFactory commonMysqlSessionFactory(DataSource commonMysqlDataSouece) throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);//驼峰


        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(commonMysqlDataSouece);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        bean.setConfiguration(configuration);
        return bean.getObject();
    }




    //transactionManager
    @Bean("commonMysqlTransactionManager")
    public PlatformTransactionManager commonMysqlTransactionManager(DataSource commonMysqlDataSouece) {
        return new DataSourceTransactionManager(commonMysqlDataSouece);
    }

}
