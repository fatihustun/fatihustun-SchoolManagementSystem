package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class VisitingResearcher extends Instructor{
    private double workingHour;
    private double hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String name, String address, String phoneNumber, List<Course> courseList,
                              double workingHour, double hourlySalary) {
        super(name, address, phoneNumber, courseList);
        this.workingHour = workingHour;
        this.hourlySalary = hourlySalary;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(double workingHour) {
        this.workingHour = workingHour;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "workingHour=" + workingHour +
                ", hourlySalary=" + hourlySalary +
                "} " + super.toString();
    }
}
