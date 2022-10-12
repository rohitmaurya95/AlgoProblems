package com.maurya.rohit;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>());

        for (int i = 0; i<100000; i++){
            System.out.println("Trying to submit task: " + i);
            threadPoolExecutor.submit(()-> {
                try {
                    Thread.sleep(getRandomNumberInRange(1000, 5000));
                    System.out.println("Completed task");
                } catch (Exception e){
                    e.printStackTrace();
                }
            });

            System.out.println("Submitted task: " + i);
        }

	// write your code here
    }
}
