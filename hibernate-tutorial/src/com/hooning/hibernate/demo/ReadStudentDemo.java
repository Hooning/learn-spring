package com.hooning.hibernate.demo;

import com.hooning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            Student tempStudent = new Student("Donald", "Duck", "double_d@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the Student object
            System.out.println("Saving the Student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // my new code

            // find out the students primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // now get a new session, new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on id: primary key
            System.out.printf("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("\nGet complete: " + myStudent.toString());

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            factory.close();
        }

    }

}
