package com.aia.kvmmp.config.spring;

import com.aia.kvmmp.web.admin.auth.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@ComponentScan(basePackages = "com.aia.kvmmp.web.admin.auth")
public class SecurityConfig {

    private final KvmmpAuthenticationProvider customAuthenticationProvider;
    private final KvmmpLoginSuccessHandler kvmmpLoginSuccessHandler;
    private final KvmmpLoginFailureHandler loginFailureHandler;
    private final KvmmpUserDetailsService customUserDetailsService;

    public SecurityConfig(
            KvmmpAuthenticationProvider customAuthenticationProvider,
            KvmmpLoginSuccessHandler kvmmpLoginSuccessHandler,
            KvmmpLoginFailureHandler loginFailureHandler,
            KvmmpUserDetailsService customUserDetailsService) {
        this.customAuthenticationProvider = customAuthenticationProvider;
        this.kvmmpLoginSuccessHandler = kvmmpLoginSuccessHandler;
        this.loginFailureHandler = loginFailureHandler;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/admin/auth/**/*").permitAll()
                        .requestMatchers("/admin/vitality/Admin/view").authenticated()
                        .requestMatchers("/admin/vitality/AdminMaster/**/*").hasRole("VITALITY"))
                .formLogin(login -> login
                        .loginProcessingUrl("/admin/login")
                        .loginPage("/admin/auth/Login/view")
                        .successHandler(kvmmpLoginSuccessHandler)
                        .failureHandler(loginFailureHandler))
                .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true))
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return customUserDetailsService;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
