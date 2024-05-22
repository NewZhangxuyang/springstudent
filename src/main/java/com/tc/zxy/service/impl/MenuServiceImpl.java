package com.tc.zxy.service.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tc.zxy.dao.MenuDao;
import com.tc.zxy.pojo.entity.QSysMenu;
import com.tc.zxy.pojo.vo.MenuVO;
import com.tc.zxy.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private static final QSysMenu menu = QSysMenu.sysMenu;
    private static final QSysMenu menuChild = QSysMenu.sysMenu;

    @Resource
    private JPAQueryFactory jpa;
    @Resource
    private MenuDao menuDao;

    @Override
    public List<MenuVO> listMenuChildren() {
        return jpa.select(Projections.bean(MenuVO.class,
                menu.pid.as("parentId"),
                menu.name.as("menuName"),
                menu.code.as("code"),
                menu.type.as("type"),
                menu.id.as("menuId")
        )).from(menu).fetch();
    }
}
