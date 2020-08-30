package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/login")
    public String Login(){
        System.out.println();
        return "login";
    }
    @RequestMapping("/assign")
    public String assign(){
        System.out.println();
        return "assign";
    }
}
