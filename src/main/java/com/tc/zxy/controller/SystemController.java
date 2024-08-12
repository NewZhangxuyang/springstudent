package com.tc.zxy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class SystemController {


    @PostMapping("/login")
    public String login(@RequestParam("username") String userName
            , @RequestParam("password") String passWord){

        return "login";
    }


}
