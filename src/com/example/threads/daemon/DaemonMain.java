package com.example.threads.daemon;

public class DaemonMain {
    public static void main(String[] args) {
        SimpleThread normal = new SimpleThread();
        SimpleThread daemon = new SimpleThread();

        daemon.setDaemon(true);

        daemon.start();
        normal.start();

        System.out.println("end of main");
    }
}
