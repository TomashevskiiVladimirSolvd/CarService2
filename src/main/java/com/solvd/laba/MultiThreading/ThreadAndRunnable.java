package com.solvd.laba.MultiThreading;

public class ThreadAndRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable is running " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(){
            public void run(){
                System.out.println("Tread is running"+Thread.currentThread().getName());
            }
        };
        thread2.start();
    }
}
