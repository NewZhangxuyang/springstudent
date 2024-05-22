package com.tc.zxy.controller;

import com.tc.zxy.pojo.vo.UserVO;
import com.tc.zxy.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permissions/")
public class UserController {

    /*
    * 复习OpenFeign的RequestInterceptor
    * 以及其它组件
    * */
    @Resource
    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserVO> getUserPermissions(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.selectUserDetailById(id));
    }

}
