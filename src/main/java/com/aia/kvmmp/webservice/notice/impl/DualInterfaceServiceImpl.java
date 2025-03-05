package com.aia.kvmmp.webservice.notice.impl;

import com.aia.kvmmp.webservice.notice.DualInterfaceService;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

@Slf4j
public class DualInterfaceServiceImpl implements DualInterfaceService, InitializingBean, DisposableBean {

    @Setter
    private Resource jsonConfigFullPath;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }

}
