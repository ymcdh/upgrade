package com.aia.kvmmp.web.admin.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class KvmmpUserVo implements Serializable, Cloneable {

    private String userId;
    private String userStatusCd;

    private List<KvmmpAuthVo> kvmmpAuthList;
}
