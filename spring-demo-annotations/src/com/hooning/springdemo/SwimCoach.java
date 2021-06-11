package com.hooning.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Paddle you feet like a Duck until you become a duck.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
