package com.hooning.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(theSwimCoach.getDailyWorkout());
        System.out.println(theSwimCoach.getDailyFortune());

        // call our new swim coach methods ... has the props values injected
        System.out.println("email: " + theSwimCoach.getEmail());
        System.out.println("team: " + theSwimCoach.getTeam());

        // close the context
        context.close();
    }
}
