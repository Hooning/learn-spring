package com.hooning.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") -> replace with default bean id
@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    // from Spring 4.3 @Autowired annotation in constructor is no longer necessary (if there is more than one you need to specify in one constructor)
    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

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
