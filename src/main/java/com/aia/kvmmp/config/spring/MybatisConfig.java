package com.aia.kvmmp.config.spring;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MybatisConfig {

    //ONLINE SQL Session Factory
    @Bean(name = "sqlSessionFactoryXSVCVMM")
    public SqlSessionFactory sqlSessionFactoryXSVCVMM(DataSource dataSourceSXVCVMM) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSourceSXVCVMM);

        // mybatis-config.xml 설정 파일 추가
        sessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource("file:${KVMMP_CONF_PATH}/mybatis/mybatis-config.xml"));

        // Mapper 파일 경로 설정
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources("file://D:/KVMMP_Git/workspace/KVMMP/kvmmp/src/main/webapp/WEB-INF/conf/mapper/**/*Mapper.xml");
        sessionFactoryBean.setMapperLocations(mapperLocations);
        sessionFactoryBean.setConfigurationProperties(getMybatisConfiurationProperties(1));

        return sessionFactoryBean.getObject();
    }

    //BATCH SQL Session Factory
    @Bean(name = "sqlSessionFactoryXSVCVMM_BATCH")
    public SqlSessionFactory sqlSessionFactoryXSVCVMM_BATCH(DataSource dataSourceSXVCVMM_BATCH) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSourceSXVCVMM_BATCH);

        // mybatis-config.xml 설정 파일 추가
        sessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource("file:${KVMMP_CONF_PATH}/mybatis/mybatis-config.xml"));

        // Mapper 파일 경로 설정
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources("file://D:/KVMMP_Git/workspace/KVMMP/kvmmp/src/main/webapp/WEB-INF/conf/mapper/**/*Mapper.xml");
        sessionFactoryBean.setMapperLocations(mapperLocations);
        sessionFactoryBean.setConfigurationProperties(getMybatisConfiurationProperties(2));

        return sessionFactoryBean.getObject();
    }

    //SEPT BATCH SQL Session Factory
    @Bean(name = "sqlSessionFactoryXSVCVMM_BATCH_SEPT")
    public SqlSessionFactory sqlSessionFactoryXSVCVMM_BATCH_SEPT(DataSource dataSourceSXVCVMM_BATCH_SEPT) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSourceSXVCVMM_BATCH_SEPT);

        // mybatis-config.xml 설정 파일 추가
        sessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource("file:${KVMMP_CONF_PATH}/mybatis/mybatis-config.xml"));

        // Mapper 파일 경로 설정
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
                .getResources("file://D:/KVMMP_Git/workspace/KVMMP/kvmmp/src/main/webapp/WEB-INF/conf/mapper/**/*Mapper.xml");
        sessionFactoryBean.setMapperLocations(mapperLocations);
        sessionFactoryBean.setConfigurationProperties(getMybatisConfiurationProperties(1));

        return sessionFactoryBean.getObject();
    }

    //Mybatis의 공통 설정 프로퍼티
    private Properties getMybatisConfiurationProperties(int type){
        Properties properties = new Properties();

        if(type == 1){
            properties.setProperty("defaultFetchSize", "10");
            properties.setProperty("defaultStatementTimeout", "120");
        }else{
            properties.setProperty("defaultFetchSize", "100");
            properties.setProperty("defaultStatementTimeout", "1800");
        }

        return properties;
    }

    //MapperScannerConfigurer 설정
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerXSVCVMM(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.aia.kvmmp");
        scannerConfigurer.setAnnotationClass(com.aia.kvmmp.foundation.database.DataSourceXSVCVMM.class);
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryXSVCVMM");

        return scannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerXSVCVMM_BATCH(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.aia.kvmmp");
        scannerConfigurer.setAnnotationClass(com.aia.kvmmp.foundation.database.DataSourceXSVCVMM_BATCH.class);
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryXSVCVMM_BATCH");

        return scannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerXSVCVMM_BATCH_SEPT(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.aia.kvmmp");
        scannerConfigurer.setAnnotationClass(com.aia.kvmmp.foundation.database.DataSourceXSVCVMM_BATCH_SEPT.class);
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryXSVCVMM_BATCH_SEPT");

        return scannerConfigurer;
    }
}