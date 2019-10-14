package edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.repository;

import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {

}
