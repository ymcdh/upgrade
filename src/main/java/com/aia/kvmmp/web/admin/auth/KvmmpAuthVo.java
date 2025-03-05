package com.aia.kvmmp.web.admin.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class KvmmpAuthVo {
    private String userId;
    private String roleId;
    private String roleUseYn;

}
