package com.hooning.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        // Coach theCoach = context.getBean("thatSillyCoach", Coach.class); // replaced with default id
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach volleyballCoach = context.getBean("volleyballCoach", Coach.class);
        Coach theSwimCoach = context.getBean("swimCoach", Coach.class);

        // call a method on the bean
        System.out.println("## call tennis Coach => get daily workout");
        System.out.println(theCoach.getDailyWorkout());

        // call a method from additional bean
        System.out.println("## call volleyball Coach => get daily workout");
        System.out.println(volleyballCoach.getDailyWorkout());

        // call a method from FortuneService autowired to TennisCoach class
        System.out.println("## call tennis Coach => get daily fortune");
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
