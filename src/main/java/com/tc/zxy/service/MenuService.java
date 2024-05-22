package com.tc.zxy.service;

import com.tc.zxy.pojo.vo.MenuVO;

import java.util.List;

public interface MenuService {
    List<MenuVO> listMenuChildren();
}
