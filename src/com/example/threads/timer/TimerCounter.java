package com.example.threads.timer;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerCounter extends TimerTask {
    private static int i;

    @Override
    public void run() {
        System.out.print(++i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\t" + i);
    }
}
