package com.hooning.hibernate.demo;

import com.hooning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create Student object
            System.out.println("Creating a new Student object");
            Student tempStudent = new Student("Hoon", "Cho", "david.hoontime@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the Student object
            System.out.println("Saving the Student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            factory.close();
        }

    }

}
