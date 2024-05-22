package com.tc.zxy.dao;

import com.tc.zxy.pojo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserDao extends JpaRepository<SysUser, Integer>, QuerydslPredicateExecutor<SysUser> {

}
