package com.hooning.springdemo;

import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Jump serve practice for 20 minutes";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

}
