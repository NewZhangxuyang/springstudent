package com.tc.zxy.service;

import com.tc.zxy.pojo.entity.Student;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Trace;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();

    @Trace()
    @Tag(key = "studentId", value = "#id")
    Student findStudentById(Integer id);

    Student saveStudent(Student student);

    Student updateStudentById(Integer id, Student student);

    Student deleteStudentById(Integer id);
}
