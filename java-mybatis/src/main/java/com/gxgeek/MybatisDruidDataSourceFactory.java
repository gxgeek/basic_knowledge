package com.gxgeek;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
public class MybatisDruidDataSourceFactory implements DataSourceFactory {

    private Properties properties;
    @Override
    public void setProperties(Properties props) {
        this.properties = props;

    }

    @Override
    public DataSource getDataSource() {

        try {
            return com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }
        return null;
    }

}
