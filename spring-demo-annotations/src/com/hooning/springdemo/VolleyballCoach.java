package com.hooning.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Override
    public String getDailyWorkout() {
        System.out.println("Coach contact: " + email);
        return "Team " + team + "!! Jump serve practice for 20 minutes";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

}
