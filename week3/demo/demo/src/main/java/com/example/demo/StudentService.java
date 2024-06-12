package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student updateStudent(Integer id, Student student);
    void deleteStudent(Integer id);

}
