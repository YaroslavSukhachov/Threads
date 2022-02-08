package com.example.threads.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumRecursiveTask extends RecursiveTask<Long> {
    private List<Long> longList;
    private int begin;
    private int end;

    public static final long TRESHOLD = 10000;

    public SumRecursiveTask(List<Long> longList, int begin, int end) {
        this.longList = longList;
        this.begin = begin;
        this.end = end;
    }

    public SumRecursiveTask(List<Long> longList) {
        this(longList, 0, longList.size());
    }

    @Override
    protected Long compute() {
        int length = end - begin;
        long result = 0;

        if (length <= TRESHOLD) {
            for (int i = begin; i < end; i++) {
                result += longList.get(i);
            }
        } else {
            int middle = begin + length / 2;
            SumRecursiveTask taskLeft = new SumRecursiveTask(longList, begin, middle);
            taskLeft.fork();

            SumRecursiveTask taskRight = new SumRecursiveTask(longList, middle, end);
            taskRight.fork();

            Long leftSum = taskLeft.join();
            Long rightSum = taskRight.join();

            result = leftSum + rightSum;
        }

        return result;
    }
}
