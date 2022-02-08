package com.example.threads.priority;

import com.example.threads.thread.TalkThread;
import com.example.threads.thread.WalkThread;

public class PriorityMain {
    public static void main(String[] args) {
        Thread walkMin = new Thread(new WalkThread(), "Min");
        Thread talkMax = new Thread(new TalkThread(), "Max");

        walkMin.setPriority(Thread.MIN_PRIORITY);
        walkMin.setPriority(Thread.MAX_PRIORITY);
        talkMax.start();
        walkMin.start();
    }
}
