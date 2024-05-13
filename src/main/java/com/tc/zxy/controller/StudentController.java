package com.tc.zxy.controller;

import com.tc.zxy.pojo.entity.Student;
import com.tc.zxy.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> queryAllStudent(HttpServletResponse response) {
        return ResponseEntity.ok(studentService.findAllStudent());
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> queryStudentById(@PathVariable("id") Integer id, HttpServletResponse response) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student, HttpServletResponse response) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student, HttpServletResponse response) {
        return ResponseEntity.ok(studentService.updateStudentById(id, student));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id, HttpServletResponse response) {
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }

}
