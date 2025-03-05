package com.aia.kvmmp.web.admin.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.annotation.Secured;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class KvmmpUserVo implements Serializable, Cloneable {

    private String userId;
    private String userStatusCd;

    private List<KvmmpAuthVo> kvmmpAuthList;
}
