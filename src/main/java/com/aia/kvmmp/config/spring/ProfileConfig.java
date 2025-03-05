package com.aia.kvmmp.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class ProfileConfig {

    //기본 프로퍼티 파일 로드 (공통프로퍼티)
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyConfigurer.setLocation(new org.springframework.core.io.FileSystemResource(System.getProperty("KVMMP_CONF_PATH") + "/properties/kvmmp.common.properties"));

        return propertyConfigurer;
    }

    //local 프로퍼티에 해당하는 프로퍼티 파일 로드
    @Bean
    @Profile("local")
    public static PropertySourcesPlaceholderConfigurer localProperties() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyConfigurer.setLocation(new org.springframework.core.io.FileSystemResource(System.getProperty("KVMMP_CONF_PATH") + "/properties/kvmmp.local.properties"));

        return propertyConfigurer;
    }

    //dev 프로퍼티에 해당하는 프로퍼티 파일 로드
    @Bean
    @Profile("dev")
    public static PropertySourcesPlaceholderConfigurer devProperties() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyConfigurer.setLocation(new org.springframework.core.io.FileSystemResource(System.getProperty("KVMMP_CONF_PATH") + "/properties/kvmmp.dev.properties"));

        return propertyConfigurer;
    }

    //uat 프로퍼티에 해당하는 프로퍼티 파일 로드
    @Bean
    @Profile("uat")
    public static PropertySourcesPlaceholderConfigurer uatProperties() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyConfigurer.setLocation(new org.springframework.core.io.FileSystemResource(System.getProperty("KVMMP_CONF_PATH") + "/properties/kvmmp.uat.properties"));

        return propertyConfigurer;
    }

    //prd 프로퍼티에 해당하는 프로퍼티 파일 로드
    @Bean
    @Profile("prd")
    public static PropertySourcesPlaceholderConfigurer prdProperties() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyConfigurer.setLocation(new org.springframework.core.io.FileSystemResource(System.getProperty("KVMMP_CONF_PATH") + "/properties/kvmmp.prd.properties"));

        return propertyConfigurer;
    }
}