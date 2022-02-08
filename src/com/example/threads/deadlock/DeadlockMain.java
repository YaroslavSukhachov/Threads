package com.example.threads.deadlock;

public class DeadlockMain {
    public static void main(String[] args) {
        InviteAction invite1 = new InviteAction("first");
        InviteAction invite2 = new InviteAction("second");

        new Thread(() -> invite1.invite(invite2)).start();
        new Thread(() -> invite2.invite(invite1)).start();
    }
}
