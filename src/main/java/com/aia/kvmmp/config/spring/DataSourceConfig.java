package com.aia.kvmmp.config.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("file:${KVMMP_CONF_PATH}/datasource/context-${spring.profiles.active}-datasource.xml")
public class DataSourceConfig {

}