package com.hoontime.hibernate.practice.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernatePracticeApp {

    public static void main(String[] args) {

        // create SessionFactory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Employee.class)
                                    .buildSessionFactory();

        try {
            // create three employees
            createEmployees(factory);

            // retrieve employee with primary key
            Employee firstEmployee = retrieveFirstRegisteredEmployee(factory);
            System.out.println("Retrieved first employee: " + firstEmployee.toString());

            // find employees with a given company
            List<Employee> schaefflerEmployees = findAllSchaefflerEmployees(factory);
            for (Employee schaefflerEmployee : schaefflerEmployees) {
                System.out.println(schaefflerEmployee);
            }

            // delete employee with given employeeId
            deleteEmployeeById(factory, 1);

        } finally {
            factory.close();
        }

    }

    private static void deleteEmployeeById(SessionFactory factory, int employeeId) {
        System.out.println("Delete employee with id: " + employeeId);

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session
            .createQuery("delete from Employee where id = '" + employeeId + "'")
            .executeUpdate();

        session.getTransaction().commit();
        System.out.println("Employee with Id: " + employeeId + " is deleted!");
    }

    private static List<Employee> findAllSchaefflerEmployees(SessionFactory factory) {
        System.out.println("Find all Schaeffler employees...");

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Employee> employeeList = session
                .createQuery("from Employee where companyName = 'Schaeffler'")
                .getResultList();

        session.getTransaction().commit();

        return employeeList;
    }

    private static void createEmployees(SessionFactory factory) {
        System.out.println("create three employees...");

        Employee employee1 = new Employee("Hoon", "Cho", "Schaeffler");
        Employee employee2 = new Employee("Noah", "Cho", "BMW");
        Employee employee3 = new Employee("Yoomin", "Cho", "Siemens");
        Employee employee4 = new Employee("Jiyeon", "Jeon", "Schaeffler");

        // create session and begin transaction
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);

        session.getTransaction().commit();
        System.out.println("Three employees successfully saved!");

    }

    private static Employee retrieveFirstRegisteredEmployee(SessionFactory factory) {
        System.out.println("retrieveFirstRegisteredEmployee...");

        int employeeId = 1;

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Employee myEmployee = session.get(Employee.class, employeeId);

        session.getTransaction().commit();

        return myEmployee;
    }

}
