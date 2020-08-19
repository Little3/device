package com.hhwy.device.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author 王阳
 * @create 2020-07-10-8:45
 * Mybatis配置
 */
@Configuration
public class MybatisConfig {
    //ResourcePatternResolver定义了getResources来查找资源
    //PathMatchingResourcePatternResolver提供了以classpath开头的通配符方式查询
    private static PathMatchingResourcePatternResolver defaultResourceLoader=new PathMatchingResourcePatternResolver();

    private static  final String MAPPER_PATH="classpath*:/config/**/*-mapper.xml";

    @Autowired
    DataSource dataSource;


    //SqlSessionTemplate对应一个sqlSession
    @Bean
    public SqlSessionTemplate getSqlSessionTemplate() throws IOException {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }

    //配置sqlSessionFactory
    //SqlSessionFactory是创建SqlSession的工厂.
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(defaultResourceLoader.getResources(MAPPER_PATH));
        SqlSessionFactory sessionFactory=null;
        try {
            sessionFactory=sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
