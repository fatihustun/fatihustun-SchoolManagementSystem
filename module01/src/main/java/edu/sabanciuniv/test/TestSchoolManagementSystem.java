package edu.sabanciuniv.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestSchoolManagementSystem {
    public static void main(String[] args) {

        saveTestdata();

    }

    private static void saveTestdata() {

        LocalDate birthdate1 = LocalDate.of(2000, 1, 1);
        Student student1 = new Student("Fatih", birthdate1, "ISTANBUL", Gender.MALE);

        LocalDate birthdate2 = LocalDate.of(1997, 9, 29);
        Student student2 = new Student("Ömer", birthdate2, "MILANO", Gender.MALE);


        LocalDate birthdate3 = LocalDate.of(1995, 3, 16);
        Student student3 = new Student("Ömer", birthdate3, "MILANO", Gender.FEMALE);



        Course course1 = new Course("Introduction to JAVA","IT526", CreditScore.four);
        Course course2 = new Course("Database","MGT505",CreditScore.three);
        Course course3 = new Course("International Law","LAW358",CreditScore.nonCredit);
        Course course4 = new Course("Enterprise JAVA","LAW358",CreditScore.nonCredit);

        List<Course> courseList1 = new ArrayList<>();
        courseList1.add(course1);
        courseList1.add(course4);

        List<Course> courseList2 = new ArrayList<>();
        courseList1.add(course2);

        List<Course> courseList3 = new ArrayList<>();
        courseList1.add(course3);

        student1.getCourseList().add(course1);
        student2.getCourseList().add(course2);
        student3.getCourseList().add(course3);
        student3.getCourseList().add(course4);

        Instructor permanentInstructor1 = new PermanentInstructor("Koray", "Istanbul","05333361243",courseList1,10000);
        Instructor permanentInstructor2 = new PermanentInstructor("Hakan", "Ankara","05386361243",courseList2,98000);
        Instructor visitingResearcher1 = new VisitingResearcher("Hakan", "Ankara","05386361243",courseList2,12.5,450);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher1);
        course4.setInstructor(visitingResearcher1);



        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
            entityManager.persist(course4);


            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);


            entityManager.persist(permanentInstructor1);
            entityManager.persist(permanentInstructor2);
            entityManager.persist(visitingResearcher1);


            entityManager.getTransaction().commit();

            System.out.println("All data persisted!...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

}
