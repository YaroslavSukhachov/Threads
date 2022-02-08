package com.example.threads.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("start of daemon thread");
                TimeUnit.MILLISECONDS.sleep(10);
            } else {
                System.out.println("start of normal thread");
            }
        } catch (InterruptedException e) {
            System.err.print(e);
        } finally {
            if (!isDaemon()) {
                System.out.println("normal thread completion");
            } else {
                System.out.println("daemon thread completion");
            }
        }
    }
}
