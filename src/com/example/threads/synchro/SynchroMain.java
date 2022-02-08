package com.example.threads.synchro;

import java.util.concurrent.TimeUnit;

public class SynchroMain {
    public static void main(String[] args) {
        try (CommonResource resource = new CommonResource("data\\thread.txt")) {
            UseFileThread thread1 = new UseFileThread("First", resource);
            UseFileThread thread2 = new UseFileThread("Second", resource);

            thread1.start();
            thread2.start();
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
