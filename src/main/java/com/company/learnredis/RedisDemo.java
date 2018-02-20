package com.company.learnredis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

    private static Jedis jedis;

    public static void main(String[] args) {

        jedis = new Jedis();

        String name = "AAQUIB";
        String country = "INDIA";
        System.out.println(jedis.ping());

        jedis.set(name, country);

        System.out.println(jedis.get(name));
    }

}
