package com.example.threads.rwelock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PointLockMain {
    public static void main(String[] args) {
        PointManager pointManager = new PointManager();
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        Point point = new Point(1, -1);
        for (int i = 0; i < 15; i++) {
            executorService.submit(new PointThread(pointManager, random.nextBoolean(), point));
        }
        executorService.shutdown();
    }
}
