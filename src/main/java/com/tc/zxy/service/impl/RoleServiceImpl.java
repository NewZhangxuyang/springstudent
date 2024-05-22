package com.tc.zxy.service.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tc.zxy.dao.RoleDao;
import com.tc.zxy.pojo.entity.QSysMenu;
import com.tc.zxy.pojo.entity.QSysRole;
import com.tc.zxy.pojo.entity.QSysRoleMenu;
import com.tc.zxy.pojo.vo.MenuVO;
import com.tc.zxy.service.MenuService;
import com.tc.zxy.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private static final QSysMenu menu = QSysMenu.sysMenu;
    private static final QSysRoleMenu roleMenu = QSysRoleMenu.sysRoleMenu;
    private static final QSysRole role = QSysRole.sysRole;

    @Resource
    private JPAQueryFactory jpa;

    @Resource
    private RoleDao roleDao;

    @Resource
    private MenuService menuService;

    @Override
    public List<MenuVO> listMenusByRoleIds(List<Integer> roleIds) {
        return jpa.select(Projections.bean(MenuVO.class, menu.id.as("menuId"), menu.name.as("menuName"), menu.code.as("code"), menu.type.as("type"), menu.pid.as("parentId"))).from(role).where(role.id.in(roleIds).and(menu.type.isNotNull())).leftJoin(roleMenu).on(role.id.eq(roleMenu.roleId)).leftJoin(menu).on(roleMenu.menuId.eq(menu.id)).distinct().fetch();

    }

    public List<MenuVO> setMenuChildren(List<MenuVO> menus) {
        List<Integer> childrenIds = new ArrayList<>();
        List<MenuVO> primalMenus = menus.stream().peek(menuVO -> menuVO.setChildren(menus.stream().filter(childrenVO -> {
            if (childrenVO.getParentId() != null && childrenVO.getParentId().equals(menuVO.getMenuId())) {
                childrenIds.add(childrenVO.getMenuId());
                return true;
            } else {
                return false;
            }
        }).toList())).toList();
        return primalMenus.stream().filter(menuVO -> !childrenIds.contains(menuVO.getMenuId())).toList();
    }
}
