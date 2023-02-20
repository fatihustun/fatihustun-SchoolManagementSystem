package edu.sabanciuniv.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private int id;

    private String courseName;
    private String courseCode;
    private CreditScore creditScore;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;

    public Course() {
    }

    public Course(String courseName, String courseCode, CreditScore creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }

    public Course(String courseName, String courseCode, CreditScore creditScore, List<Student> studentList) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
        this.studentList = studentList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
