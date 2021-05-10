package com.hooning.springdemo;

public class TrackCoachWithDestroyMethod implements Coach, DisposalBean {

    private FortuneService fortuneService;

    public TrackCoachWithDestroyMethod() {}

    public TrackCoachWithDestroyMethod(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // add a destroy method
    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }

    @Override
    public void destroy() {
        System.out.println("TrackCoach: inside method destroy()");
    }
}
