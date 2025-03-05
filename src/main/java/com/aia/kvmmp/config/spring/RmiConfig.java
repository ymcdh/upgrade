package com.aia.kvmmp.config.spring;

import com.aia.kvmmp.webservice.notice.impl.DualInterfaceServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aia.kvmmp.webservice.notice.DualInterfaceService;

@Configuration
@PropertySource("file:${KVMMP_CONF_PATH}/properties/kvmmp.${spring.profiles.active}.properties")
@EnableTransactionManagement
public class RmiConfig {

    @Value("${KVMMP_CONF_PATH}")
    private String kvmmpConfPath;

    @Bean
    public DualInterfaceService dualInterfaceService() {
        DualInterfaceServiceImpl service = new DualInterfaceServiceImpl();

        // 프로퍼티 값을 설정 (Resource 객체 사용)
        Resource jsonConfigPath = new FileSystemResource(kvmmpConfPath + "/cache/kvmmp.${spring.profiles.active}.dualInterfaceService.json");
        service.setJsonConfigFullPath(jsonConfigPath);

        return service;
    }
}
