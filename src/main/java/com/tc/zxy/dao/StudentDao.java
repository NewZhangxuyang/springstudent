package com.tc.zxy.dao;

import com.tc.zxy.pojo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {
    Student  findStudentById(Integer id);
}
