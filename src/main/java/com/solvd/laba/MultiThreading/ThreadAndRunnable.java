package com.solvd.laba.MultiThreading;

public class ThreadAndRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("It's Running by using Runnable Interface: " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread() {
            public void run() {
                System.out.println("It's Running by using Thread class: " + Thread.currentThread().getName());
            }
        };
        thread2.start();
    }
}
