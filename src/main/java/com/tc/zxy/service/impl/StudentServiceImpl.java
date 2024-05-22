package com.tc.zxy.service.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tc.zxy.common.exception.StudentNotFoundException;
import com.tc.zxy.dao.StudentDao;
import com.tc.zxy.pojo.entity.Student;
import com.tc.zxy.pojo.entity.SysRole;
import com.tc.zxy.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;


    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {
        if (studentDao.findStudentById(id) == null) {
            throw new StudentNotFoundException("id is " + id + "  Student not found");
        }
        return studentDao.findStudentById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student updateStudentById(Integer id, Student student) {
        if (studentDao.findStudentById(id) == null) {
            throw new StudentNotFoundException("id is " + id + "  Student not found");
        }
        student.setId(id);
        return studentDao.save(student);
    }

    @Override
    public Student deleteStudentById(Integer id) {
        Student deleteStudent = studentDao.findStudentById(id);
        if (deleteStudent == null) {
            throw new StudentNotFoundException("id is " + id + "  Student not found");
        }
        studentDao.deleteById(id);
        return deleteStudent;
    }
}
