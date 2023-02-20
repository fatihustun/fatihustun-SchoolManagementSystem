package edu.sabanciuniv.model;


import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private Gender gender;

    @ManyToMany
    private List<Course> courseList = new ArrayList<>();



    public Student() {
    }

    public Student(String name, LocalDate birthDate, String address, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }

    public Student(String name, LocalDate birthDate, String address, Gender gender, List<Course> courseList) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }


}

