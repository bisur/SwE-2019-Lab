package edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.service;

import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.model.Student;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
   List<Student> displayAllStudent();
   Student registerNewStudent(Student student);
   Student findById(int id);
   // Page<Student> getAllStudentPaged(int pageNo);
    void deleteStudent(Student student);
    void deleteStudentById(int studentId);
    Student update(Student student);
}
