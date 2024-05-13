package com.tc.zxy.service;

import com.tc.zxy.pojo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();

    Student findStudentById(Integer id);

    Student saveStudent(Student student);

    Student updateStudentById(Integer id, Student student);

    Student deleteStudentById(Integer id);
}
