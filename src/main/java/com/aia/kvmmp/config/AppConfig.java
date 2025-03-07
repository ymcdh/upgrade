package com.aia.kvmmp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc   // 공통 설정에서만 @EnableWebMvc 사용
@ComponentScan(
        basePackages = "com.aia.kvmmp"
)  // 공통 Bean 스캔
public class AppConfig {

}
