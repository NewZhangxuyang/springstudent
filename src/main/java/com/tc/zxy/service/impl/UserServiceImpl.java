package com.tc.zxy.service.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tc.zxy.dao.UserDao;
import com.tc.zxy.pojo.entity.*;
import com.tc.zxy.pojo.vo.MenuVO;
import com.tc.zxy.pojo.vo.RoleVO;
import com.tc.zxy.pojo.vo.UserVO;
import com.tc.zxy.service.UserService;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final QSysUser user = QSysUser.sysUser;
    private static final QSysRole role = QSysRole.sysRole;
    private static final QSysUserRole userRole = QSysUserRole.sysUserRole;
    @Resource
    private UserDao userDao;
    @Resource
    private JPAQueryFactory jpa;

    @Override
    public List<RoleVO> listRolesByUserId(Integer userId) {
        return jpa.select(Projections.bean(RoleVO.class,
                        role.id.as("id"),
                        role.name.as("roleName"),
                        role.remark.as("remark")
                )).from(user).where(user.id.eq(userId))
                .leftJoin(userRole).on(user.id.eq(userRole.userId))
                .leftJoin(role).on(userRole.roleId.eq(role.id))
                .fetch();
    }
}
