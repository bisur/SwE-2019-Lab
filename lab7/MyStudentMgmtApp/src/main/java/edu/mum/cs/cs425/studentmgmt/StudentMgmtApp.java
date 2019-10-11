package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.ClassRoom;
import edu.mum.cs.cs425.studentmgmt.model.Course;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentREpository;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {
   
	@Autowired
    private StudentREpository studentRepository;
	// I am using one repository that saves the student only




	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}
	
	
	List<Student>students= new ArrayList<Student>();
	
	public void saveStudent() {
		 
		Student  s = new Student();
       s.setStudentNumber(000610001);
       s.setMiddleName("Tekle");
       s.setFirstName("Bisrat");
       s.setLastName("Kidane");
       s.setCgpa(3.93);
       s.setDateOfEnrollment(LocalDate.of(2019, 02, 11));
      Student s1 =new Student();
      s1.setStudentNumber(000610001);
      s1.setMiddleName("John");
      s1.setFirstName("Akile");
      s1.setLastName("Afwerki");
      s1.setCgpa(3.93);
      s1.setDateOfEnrollment(LocalDate.of(2019, 02, 11));
      
      students.add(s1);
       students.add(s);
    
       Transcript t1 = new Transcript();
       t1.setDegreeTitle("MSCS");
       
       Transcript t2 = new Transcript();
       t2.setDegreeTitle("MSCS");
      
       s.setTranscript(t1);
       s1.setTranscript(t2);
       
       ClassRoom cr1= new ClassRoom("Maclaughn", 219);
      cr1.setStudents(students);
       s.setClassRoom(cr1);
       s1.setClassRoom(cr1);
       
      List<Course> courseList= Arrays.asList(new Course("SWE"), new Course("WAP"),
    		                                new Course("EA"));
      s.setCourses(courseList);
       
      studentRepository.save(s);
       studentRepository.save(s1);
       
	}
	 
	 

	@Override
	public void run(String... args) throws Exception {
      saveStudent();
	}

}
