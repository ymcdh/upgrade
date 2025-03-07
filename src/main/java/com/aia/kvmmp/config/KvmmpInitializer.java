package com.aia.kvmmp.config;

import com.aia.kvmmp.config.servelt.AdminServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class KvmmpInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        // ✅ 1. 루트 애플리케이션 컨텍스트 생성 (공통 설정)
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);  // 공통 설정 등록

        servletContext.addListener(new ContextLoaderListener(rootContext));

        // ✅ 2. DispatcherServlet 설정 (각각의 서블릿)
        registerDispatcherServlet(servletContext, "admin", AdminServlet.class, "/admin/*");
        //registerDispatcherServlet(servletContext, "user", UserConfig.class, "/user/*");
        //registerDispatcherServlet(servletContext, "vitality", VitalityConfig.class, "/vitality/*");
    }

    private void registerDispatcherServlet(ServletContext servletContext, String servletName,
                                           Class<?> configClass, String urlPattern) {
        AnnotationConfigWebApplicationContext servletContextConfig = new AnnotationConfigWebApplicationContext();
        servletContextConfig.register(configClass);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(servletName, new DispatcherServlet(servletContextConfig));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(urlPattern);
    }
}