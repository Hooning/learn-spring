package com.hooning.springdemo;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "It is your Sad day";
    }

}
