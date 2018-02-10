package com.company.learnjava;

import com.company.healthchecks.BaseHealthCheck;
import com.company.healthchecks.DatabaseHealthCheck;
import com.company.healthchecks.NetworkHealthCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppStartUp {

    private static CountDownLatch countDownLatch;
    private static List<BaseHealthCheck> baseHealthChecks;
    private final static AppStartUp INSTANCE = new AppStartUp();

    private AppStartUp() {
    }

    public static AppStartUp getInstance(){
        return INSTANCE;
    }

    public static boolean startApp() throws InterruptedException {

        baseHealthChecks = new ArrayList<BaseHealthCheck>(2);
        countDownLatch = new CountDownLatch(2);

        NetworkHealthCheck networkHealthCheck =
                new NetworkHealthCheck("NetworkHealthCheck", countDownLatch);

        baseHealthChecks.add(networkHealthCheck);

        DatabaseHealthCheck databaseHealthCheck =
                new DatabaseHealthCheck("DatabaseHealthCheck", countDownLatch);

        baseHealthChecks.add(databaseHealthCheck);

        Executor executor = Executors.newFixedThreadPool(baseHealthChecks.size());

        for(BaseHealthCheck b : baseHealthChecks){
            executor.execute(b);
        }

        countDownLatch.await();

        for(BaseHealthCheck b : baseHealthChecks){
            if(!b.isServiceUp()){
                return false;
            }
        }
        return true;
    }
}
;