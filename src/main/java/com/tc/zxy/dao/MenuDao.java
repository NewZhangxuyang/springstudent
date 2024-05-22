package com.tc.zxy.dao;

import com.tc.zxy.pojo.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.awt.*;

public interface MenuDao extends JpaRepository<SysMenu, Integer>, QuerydslPredicateExecutor<SysMenu> {
}
