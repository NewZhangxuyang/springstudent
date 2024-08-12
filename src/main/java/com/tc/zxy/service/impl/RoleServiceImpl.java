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
        return jpa.select(
                        Projections.bean(MenuVO.class,
                                menu.id.as("menuId"),
                                menu.name.as("menuName"),
                                menu.code.as("code"),
                                menu.type.as("type"),
                                menu.pid.as("parentId")))
                .from(role).where(role.id.in(roleIds)
                        .and(menu.type.isNotNull()))
                .leftJoin(roleMenu)
                .on(role.id.eq(roleMenu.roleId))
                .leftJoin(menu).on(roleMenu.menuId.eq(menu.id)).distinct().fetch();
    }


    /**
     * 以当前权限组中的根节点为基准，递归构造权限树
     * 根节点：当前用户权限中的顶层节点
     * 流式构造
     * @return List<MenuVO>
     */
    public List<MenuVO> setMenuChildren(List<MenuVO> menus) {
        List<Integer> allMemuIds = menus.stream().map(MenuVO::getMenuId).toList();
        /*当前Menu中的顶层节点*/
        return  menus.stream().filter(menuVO -> !allMemuIds.contains(menuVO.getParentId()))
                .peek(parentMenu -> recursionChildrenTree(parentMenu, menus))
                .toList();
    }


    /**
     * 递归构造权限树
     */
    private void recursionChildrenTree(MenuVO root, List<MenuVO> allMenus) {
        allMenus.forEach(menuVO -> {
            if (menuVO.getParentId().equals(root.getMenuId())) {
                recursionChildrenTree(menuVO, allMenus);
                List<MenuVO> children = new ArrayList<>();
                if (root.getChildren() != null) {
                    children = root.getChildren();
                }
                children.add(menuVO);
                root.setChildren(children);
            }
      });
    }
}
