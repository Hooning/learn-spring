package com.hooning.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        Coach tottenhamCoach = context.getBean("mySoccerCoach", Coach.class);
        Coach LiverpoolCoach = context.getBean("mySoccerCoach", Coach.class);

        // check if they are the same
        boolean result = (tottenhamCoach == LiverpoolCoach);

        // print out the results
        System.out.println("Pointing to the same object: " + result);

        System.out.println("Memory location for tottenhamCoach: " + tottenhamCoach);

        System.out.println("Memory location for LiverpoolCoach: " + LiverpoolCoach);

        // close the context
        context.close();

    }
}
