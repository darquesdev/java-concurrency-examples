package com.github.darquesdev.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    static class AtomicCounter {
        private AtomicInteger count = new AtomicInteger(0);

        public int incrementAndGet() {
            int n = count.incrementAndGet();
            System.out.println(n);
            return n;
        }

        public int getCount() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        AtomicCounter atomicCounter = new AtomicCounter();

        for(int i = 0; i < 100000; i++) {
            executorService.submit(atomicCounter::incrementAndGet);
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final Count is : " + atomicCounter.getCount());
    }
}
