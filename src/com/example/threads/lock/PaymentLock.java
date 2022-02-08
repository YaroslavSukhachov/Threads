package com.example.threads.lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PaymentLock {
    private int amount;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void doPayment() {
        try {
            System.out.println("Start payment(lock)");

            lock.lock();
            while (amount <= 0) {
                condition.await();
            }

            System.out.println("Payment(lock) is closed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void init() {
        try {
            lock.lock();
            System.out.print("Init amount: ");
            amount = new Scanner(System.in).nextInt();
        } finally {
            condition.signal();
            lock.unlock();
        }
    }
}
