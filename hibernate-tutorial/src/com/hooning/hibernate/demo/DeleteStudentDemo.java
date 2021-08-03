package com.hooning.hibernate.demo;

import com.hooning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            // delete Student
            System.out.println("Deleting the student: " + myStudent.toString());
            session.delete(myStudent);

            // delete student id = 2
            System.out.println("Deleting Student with id = '2'");
            session
                .createQuery("delete from Student where id = 2")
                .executeUpdate();

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
