package edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.service.impl;

import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.model.Student;
import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.repository.IStudentRepository;
import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.service.IStudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public List<Student> displayAllStudent() {
        return studentRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Student registerNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Student student) {
      studentRepository.delete(student);
    }

    @Override
    public void deleteStudentById(int studentId) {
         studentRepository.deleteById(studentId);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }


}
