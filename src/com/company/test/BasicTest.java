package com.company.test;

import java.util.HashMap;
import java.util.Map;

public class BasicTest {

    private static void change(IceCream iceCream){
        iceCream.setFlavor("Something");
    }

    public static void main(String[] args) {

        IceCream iceCream = new IceCream("Vanilla", 2);
        change(iceCream);
        System.out.println(iceCream);
        Map<String, String> mymp = new HashMap<String, String>();
        String me = new String("Aaquib");
        mymp.put(me, "Javed");
        mymp.put("Abhishek", "Sharma");
        me = "Khan";
        if(mymp.containsKey("Aaquib")){
            System.out.println("Yes, it is!");
        }else {
            System.out.println("No dude!, it doesn't");
        }

    }
}
