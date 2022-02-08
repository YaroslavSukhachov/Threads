package com.example.threads.callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ActionMain {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 100).boxed().collect(Collectors.toList());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new ActionCallable(list));
        executorService.shutdown();

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
