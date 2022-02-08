package com.example.threads.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinTaskMain {
    public static void main(String[] args) {
        int end = 1_000_000;

        List<Long> numbers = LongStream.range(0, end).boxed().collect(Collectors.toList());
        ForkJoinTask<Long> task = new SumRecursiveTask(numbers);
        long result = new ForkJoinPool().invoke(task);
        System.out.println(result);
    }
}
