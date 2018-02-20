package com.company.oddeven;

class Printer{

    boolean isOdd = true;

    public synchronized void printOdd(int number){

        while(isOdd == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OddPrinter : " + number);
        isOdd = false;
        notifyAll();
    }

    public synchronized void printEven(int number){

        while(isOdd == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("EvenPrinter : " + number);
        isOdd = true;
        notifyAll();
    }



}

class TaskEvenOdd implements Runnable{
    private Printer printer;
    private boolean isEven;
    private int maxLimit;

    public TaskEvenOdd(Printer printer, boolean isEven, int max) {
        this.printer = printer;
        this.isEven = isEven;
        this.maxLimit = max;
    }

    public void run() {

        int start = (!isEven)? 1 : 2;

        while(start <= maxLimit){
            if(isEven){
                printer.printEven(start);
            }else {
                printer.printOdd(start);
            }
            start += 2;
        }
    }
}

public class OddEvenDemo {

    public static void main(String[] args) {
        int max = 20;
        Printer printer = new Printer();
        Thread oddPrinter = new Thread(new TaskEvenOdd(printer, false, 20));
        Thread evenPrinter = new Thread(new TaskEvenOdd(printer,true, 20));

        oddPrinter.start();
        evenPrinter.start();
    }
}
