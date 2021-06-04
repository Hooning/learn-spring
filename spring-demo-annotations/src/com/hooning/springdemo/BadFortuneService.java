package com.hooning.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BadFortuneService implements FortuneService {

    @Value("${demo.fortune.bad-fortunes}")
    private String[] badFortunes;

    private final Random myRandom = new Random();

    @Override
    public String getFortune() {
        return badFortunes[myRandom.nextInt(badFortunes.length)];
    }

}
