package com.hhwy.device.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.hhhwy.common.property.$;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 王阳
 * @create 2020-07-10-8:46
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource druidDataSource() {

        String url= $.get("datasource.url");
        String username=$.get("datasource.username");
        String password=$.get("datasource.password");
        String driverClassName=$.get("datasource.driver-class-name","com.mysql.jdbc.Driver");
        int minIdle=$.getInt("datasource.min-idle",20);
        boolean removeAbandoned=$.getBoolean("datasource.remove-abandoned",true);
        int maxActive=$.getInt("datasource.max-active",100);
        int maxWait=$.getInt("datasource.max-wait",10000);
        int initialSize=$.getInt("datasource.initial-size",10);
        String validationQuery=$.get("datasource.validation-query","SELECT current_date");
        boolean testWhileIdle=$.getBoolean("datasource.test-while-idle",true);

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setRemoveAbandoned(removeAbandoned);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        return druidDataSource;
    }

}
