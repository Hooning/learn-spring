package com.hooning.hibernate.demo;

import com.hooning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create three Students object
            System.out.println("Creating three new Student objects");
            Student tempStudent1 = new Student("Jiyeon", "Jeon", "jazzydus@gmail.com");
            Student tempStudent2 = new Student("Noah", "Cho", "noahcho2019@gmail.com");
            Student tempStudent3 = new Student("Yoomin", "Cho", "yoomincho2013@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the Student object
            System.out.println("Saving the Students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

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
