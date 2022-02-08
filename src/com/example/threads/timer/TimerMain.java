package com.example.threads.timer;

import java.util.Timer;

public class TimerMain {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerCounter(), 100, 3000);
    }
}
