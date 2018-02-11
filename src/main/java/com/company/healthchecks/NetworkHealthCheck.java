package com.company.healthchecks;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthCheck extends BaseHealthCheck {

    public NetworkHealthCheck(String healthName, CountDownLatch countDownLatch) {
        super(healthName, countDownLatch);
    }

    @Override
    public void verifyService() throws InterruptedException {
        System.out.println("Checking Health of " + getHealthName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
        System.out.println("Health of " + getHealthName() + "is Okay");
    }
}
