package com.aia.kvmmp.web.admin.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class KvmmAuthController {

    @RequestMapping("/auth/Login/view/main")
    public String systemBatch1(){
        log.debug("KvmmAuthController Call");
        return "/admin/auth/LoginMain.jsp";
    }
}
