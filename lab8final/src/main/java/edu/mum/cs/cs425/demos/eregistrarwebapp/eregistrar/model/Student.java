package edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter@Setter
    private int studentId;
    @Getter@Setter

    @NotNull(message = "Student number should not be empty")
    @Column(name = "StudentNumber", nullable = false)
    private long studentNumber;
    @Getter@Setter
    @NotNull(message = "Student first name should not be empty")
    //@Size(min=2, message = "First Name should have minimum 2 letters")
    @Column(name = "FirstName", nullable = false)
    private String firstName;
    @Getter@Setter
    @Column(name = "MiddleName", nullable = false)
    private String middleName;
    @Getter@Setter
    @Column(name = "LastName", nullable = false)
    private String lastName;
    @Getter@Setter
    @Column(name = "coursegpa", nullable = false)
    private double cgpa;
    @Getter@Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EnrollementDate", nullable = true)
    private LocalDate enrollmentDate;
    @Getter@Setter
    @Column(name = "IsInternational", nullable = false)
    private String isInternational;

    public Student(@NotBlank(message = "Student number should not be empty") long studentNumber, String firstName, String middleName, String lastName, double cgpa, LocalDate enrollmentDate, String isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }
}