package com.github.darquesdev.concurrency;

import static java.lang.System.*;

public class RunnableExample implements Runnable {

    public static void main(String[] args) {
        out.println("Inside : " + Thread.currentThread().getName());

        out.println("Creating Runnable...");
        Runnable runnable = new RunnableExample();

        out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        out.println("Starting Thread...");
        thread.start();

        new Thread(() -> out.println("Let's rock! in " + Thread.currentThread().getName())).start();

    }

    @Override
    public void run() {
        out.println("Inside : " + Thread.currentThread().getName());
    }
}

