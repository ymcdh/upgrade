package com.aia.kvmmp.web.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

public class UserInterceptor implements HandlerInterceptor {

    private List<String> authSkipEndWithUriList;

    @PostConstruct
    private void init(){
        authSkipEndWithUriList = Arrays.asList(new String[]{
             "/user/common/Login/insert"
           , "/user/common/Login/view"
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
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{

    }
}

