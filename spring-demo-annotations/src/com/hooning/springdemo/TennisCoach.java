package com.hooning.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("thatSillyCoach") -> replace with default bean id
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired // Field level injection (Java Reflection technology is used)
    @Qualifier("badFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartupStuff() method");
    }

    // define my destroy method - Code will be executed before bean is destroyed
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff() method");
    }

    // from Spring 4.3 @Autowired annotation in constructor is no longer necessary (if there is more than one you need to specify in one constructor)

    /* Using constructor for dependency injection */
//    @Autowired // can be omitted only from constructor
//    public TennisCoach(FortuneService theFortuneService) {
//        this.fortuneService = theFortuneService;
//    }

    /* Using setter method for dependency injection */
//    @Autowired // if it is not a constructor you need @Autowired annotation
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside default setFortuneService() method");
//        this.fortuneService = fortuneService;
//    }

    /* Using any method name for dependency injection */
//    @Autowired // if it is not a constructor you need @Autowired annotation
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside default doSomeCrazyStuff() method");
//        this.fortuneService = fortuneService;
//    }

    // you need @Autowired Annotation if you have additional constructor
    // public TennisCoach() {}

    @Override
    public String getDailyWorkout() {
        return "Forehand swing 100 times";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
