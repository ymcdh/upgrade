package com.aia.kvmmp.web.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class KvmmInterceptor implements HandlerInterceptor {

    private List<String> authSkipEndWithUriList;

    @PostConstruct
    private void init(){
        authSkipEndWithUriList = Arrays.asList(new String[]{
             "/admin/auth/Login/insert"
           , "/admin/auth/Login/view"
           , "/admin/auth/Login/view/main"
           , ".css"
           , ".js"
           , ".gif"
           , ".jpg"
           , ".map"
           , ".ttf"
           , ".woff"
           , ".woff2"
        });
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("Interceptor 실행됨: " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{

    }
}

