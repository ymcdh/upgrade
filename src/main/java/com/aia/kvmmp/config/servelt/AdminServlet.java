package com.aia.kvmmp.config.servelt;

import com.aia.kvmmp.web.common.interceptor.KvmmInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Configuration
@ComponentScan(
        basePackages = "com.aia.kvmmp.web.admin",
        includeFilters = @ComponentScan.Filter(org.springframework.stereotype.Controller.class),
        excludeFilters = {
                @ComponentScan.Filter(org.springframework.stereotype.Service.class),
                @ComponentScan.Filter(org.springframework.stereotype.Repository.class)
        }
)
public class AdminServlet implements WebMvcConfigurer {

    @Bean
    public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping(){
        BeanNameUrlHandlerMapping mapping = new BeanNameUrlHandlerMapping();
        mapping.setAlwaysUseFullPath(true);
        mapping.setOrder(1);
        log.info("✅ HandlerMappingIntrospector 등록됨");
        return mapping;
    }

    @Bean
    public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter(){
        return new SimpleControllerHandlerAdapter();
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(){
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(
                MediaType.valueOf("text/json;charset=UTF-8"),
                MediaType.APPLICATION_JSON
        ));

        return converter;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(List.of(MediaType.valueOf("text/html; charset=EUC-KR")));

        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        log.info("✅ AdminServlet Interceptor 등록됨");
       registry.addInterceptor(new KvmmInterceptor()).addPathPatterns("/admin/**");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setOrder(2);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix("");

        return resolver;
    }
}
