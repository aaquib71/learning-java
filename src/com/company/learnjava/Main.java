package com.company.learnjava;

public class Main {

    public static void main(String[] args) {
        //AppStartUp appStartUp = AppStartUp.getInstance();
        boolean success = false;
        try {
            success = AppStartUp.startApp();
        } catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Some error occurred!");
        }

        System.out.println("External services validation completed !! Result was :: "+ success);
    }

}
