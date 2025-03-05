package com.aia.kvmmp.web.admin.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        // 로그 기록 (필요한 경우)
        System.out.println("접근이 거부됨: " + request.getRequestURI());

        // 403 Forbidden 응답 코드와 함께 에러 페이지로 리다이렉트
        response.sendRedirect("/admin/auth/AccessError/view");
    }
}
