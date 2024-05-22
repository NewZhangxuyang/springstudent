package com.tc.zxy.service;

import com.tc.zxy.pojo.vo.MenuVO;
import com.tc.zxy.pojo.vo.RoleVO;

import java.util.List;

public interface RoleService {
    List<MenuVO> listMenusByRoleIds(List<Integer> roleIds);

}
