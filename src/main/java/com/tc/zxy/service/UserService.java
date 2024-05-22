package com.tc.zxy.service;

import com.tc.zxy.pojo.vo.RoleVO;
import com.tc.zxy.pojo.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<RoleVO> listRolesByUserId(Integer userId);
    UserVO selectUserDetailById(Integer userId);
}
