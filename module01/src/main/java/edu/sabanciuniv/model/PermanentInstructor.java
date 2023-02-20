package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class PermanentInstructor extends Instructor{
    private double salary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, String phoneNumber,
                               List<Course> courseList, double salary) {
        super(name, address, phoneNumber, courseList);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
