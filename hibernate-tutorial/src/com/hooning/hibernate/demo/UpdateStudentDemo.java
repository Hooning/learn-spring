package com.hooning.hibernate.demo;

import com.hooning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            // now get a new session, new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("\nGet complete: " + myStudent.toString());

            System.out.println("Updating Student...");
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();

            // update email to all student
            System.out.println("Update email address to all students");

            session = factory.getCurrentSession();
            session.beginTransaction();

            session
                .createQuery("update Student set email = 'foobar@gmail.com'")
                .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            factory.close();
        }

    }

}
