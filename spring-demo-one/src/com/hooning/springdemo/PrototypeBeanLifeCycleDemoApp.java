package com.hooning.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeBeanLifeCycleDemoApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("prototype-beanLifeCycle-applicationContext.xml");

        // retrieve bean from spring container
        TrackCoachWithDestroyMethod theCoach = context.getBean("myCoach", TrackCoachWithDestroyMethod.class);

        System.out.println(theCoach.getDailyWorkout());
        theCoach.destroy();

        // close the context
        context.close();


    }
}
