package com.aia.kvmmp.web.admin.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class KvmmpCustomUser extends User {
    private static final long serialVesrionUID = 1L;

    @Getter
    private KvmmpUserVo kvmmpUserVo;

    public KvmmpCustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public KvmmpCustomUser(KvmmpUserVo vo){
        super(vo.getUserId(), "none", vo.getKvmmpAuthList().stream()
                                                        .map(auth -> new SimpleGrantedAuthority(auth.getRoleId()))
                                                        .collect(Collectors.toList()));

        this.kvmmpUserVo = vo;
    }
}
