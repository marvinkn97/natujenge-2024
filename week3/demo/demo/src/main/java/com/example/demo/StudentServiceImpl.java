package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return getStudent(id);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        var existingStudent = getStudent(id);

        if (!student.getStudentName().isBlank()) {
            existingStudent.setStudentName(student.getStudentName());
        }

        if (!student.getStudentAddress().isBlank()) {
            existingStudent.setStudentAddress(student.getStudentAddress());
        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Integer id) {
        var existingStudent = getStudent(id);
        studentRepository.delete(existingStudent);
    }

    private Student getStudent(Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student not found"));
    }

}
