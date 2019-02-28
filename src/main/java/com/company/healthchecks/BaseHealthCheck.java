package com.company.healthchecks;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthCheck implements Runnable{
    private String healthName;
    private CountDownLatch latch;

    public boolean isServiceUp() {
        return serviceUp;
    }

    private boolean serviceUp;

    public String getHealthName() {
        return healthName;
    }

    public BaseHealthCheck(String healthName, CountDownLatch countDownLatch) {
        this.healthName = healthName;
        this.latch = countDownLatch;
        this.serviceUp = false;
    }

    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable e){
            e.printStackTrace(System.err);
            serviceUp = false;
        } finally {
            if(latch != null){
                latch.countDown();
            }
        }

    }

    public abstract void verifyService() throws InterruptedException;
}
