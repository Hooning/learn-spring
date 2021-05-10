package com.hooning.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
    public String[] fortuneData = {"[Yeah] Today is your lucky day!", "[OK] Today is just a normal day!", "[WTF] Today is really bad day!"};

    // create a random number generator
    private final Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortuneData.length);
        return fortuneData[index];
    }
}
