package com.example.threads.join;

import java.util.concurrent.TimeUnit;

public class JoinMain {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("start 1");

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end 1");
        }).start();

        JoinThread joinThread = new JoinThread();
        joinThread.start();

        try {
            joinThread.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end of " + Thread.currentThread().getName());
    }
}
