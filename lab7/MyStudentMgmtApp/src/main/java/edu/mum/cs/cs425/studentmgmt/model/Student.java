package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_Id", nullable = false)
	private long studentId;
	@Column(name = "Student_Number", nullable = false)
	private Long studentNumber;
	@Column(name = "First_Name", nullable = false)
	private String firstName;
	@Column(name = "Middle_Name", nullable = true)
	private String middleName;
	@Column(name = "Last_Name", nullable = false)
	private String lastName;
	@Column(name = "Course_Gpa", nullable = true)
	private double cgpa;
	@Column(name = "Date_Of_Enroll", nullable = false)
	private LocalDate dateOfEnrollment;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="Transcript_Id")
	private Transcript transcript;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ClassRoom_Id")
	private ClassRoom classRoom;
	
	// A student has list of courses
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course",
    joinColumns = { @JoinColumn(name = "Student_Id") },
    inverseJoinColumns = { @JoinColumn(name = "Course_Id") })
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	// default constructor
	public Student() {

	}
	

	public Long getStudentId() {
		return studentId;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	
	

}
