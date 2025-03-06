package com.aia.kvmmp.web.admin.auth;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.wsdl.Output;
import java.util.Collection;

@Component
public class KvmmpAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = null;
        Output output = null;
        Collection<GrantedAuthority> authorities = null;
        String userId = null;
        String password = null;

        try {
            userId = authentication.getName();
            password = (String)authentication.getCredentials();
        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

        return new UsernamePasswordAuthenticationToken(userId, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
