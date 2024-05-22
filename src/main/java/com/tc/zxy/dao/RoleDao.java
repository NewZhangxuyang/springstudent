package com.tc.zxy.dao;

import com.tc.zxy.pojo.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoleDao extends JpaRepository<SysRole, Integer>, QuerydslPredicateExecutor<SysRole> {
}
