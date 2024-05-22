package com.tc.zxy.dao;

import com.tc.zxy.pojo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer>, QuerydslPredicateExecutor<Student> {
    Student findStudentById(Integer id);
}
