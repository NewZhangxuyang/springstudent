package com.tc.zxy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class OpenFeignController {


    @GetMapping("/test")
    public String test(@RequestHeader("JWT") String jwt) {
        if ("admin".equals(jwt)) {
            return "Hello, admin!";
        }
        return "Hello, user!";
    }
}
