package com.hooning.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.hooning.springdemo")
public class SportConfig {

    // define bean for out sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach() { // beanId => 'swimCoach'
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());

        return mySwimCoach;
    }

}
