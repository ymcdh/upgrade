package com.aia.kvmmp.config.spring;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(
        basePackages = "com.aia.kvmmp",
        scopedProxy = ScopedProxyMode.TARGET_CLASS
)
@EnableTransactionManagement
public class ContextAspectConfig {

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
}
