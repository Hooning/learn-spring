package com.hooning.hibernate.demo;

import com.hooning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session
                .createQuery("from Student")
                    .getResultList();

            // display the students
            printStudents(theStudents);

            // query students that has lastName = 'Cho'
            System.out.println("\nStudents that has lastName = 'Cho'");
            theStudents = session
                    .createQuery("from Student s where s.lastName = 'Cho'")
                    .getResultList();

            // display the students
            printStudents(theStudents);

            // query students that has lastName = 'Cho' OR firstName = 'Jiyeon'
            System.out.println("\nStudents that has lastName = 'Cho' or firstName = 'Jiyeon");
            theStudents = session
                    .createQuery("from Student s where s.lastName = 'Cho'" +
                            " OR s.firstName = 'Jiyeon'")
                    .getResultList();

            // display the students
            printStudents(theStudents);

            // query students that uses gmail
            System.out.println("\nStudents that uses gmail");
            theStudents = session
                    .createQuery("from Student s where " +
                            "s.email like '%@gmail.com'")
                    .getResultList();

            // display the students
            printStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            factory.close();
        }

    }

    private static void printStudents(List<Student> theStudents) {
        for (Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }

}
