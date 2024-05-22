package com.tc.zxy.service.impl;

import com.tc.zxy.pojo.entity.QSysMenu;
import com.tc.zxy.pojo.entity.QSysRoleMenu;
import com.tc.zxy.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    private static final QSysMenu menu = QSysMenu.sysMenu;
    private static final QSysRoleMenu roleMenu = QSysRoleMenu.sysRoleMenu;

}
