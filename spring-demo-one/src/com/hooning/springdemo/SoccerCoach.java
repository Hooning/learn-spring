package com.hooning.springdemo;

public class SoccerCoach implements Coach {

    private final FortuneService fortuneService;

    public SoccerCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Ball lifting 20 minutes";
    }

    @Override
    public String getDailyFortune() {
        return "This is Soccer: " + fortuneService.getFortune();
    }

}
