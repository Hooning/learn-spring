package com.hooning.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        // Coach theCoach = context.getBean("thatSillyCoach", Coach.class); // replaced with default id
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach volleyballCoach = context.getBean("volleyballCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method from additional bean
        System.out.println(volleyballCoach.getDailyWorkout());

        // call a method from FortuneService autowired to TennisCoach class
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
