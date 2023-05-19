package com.solvd.laba.MultiThreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;

public class ConnectionPool {
    private BlockingQueue<BufferedWriter> connections;
    private Semaphore semaphore;

    private static ConnectionPool instance;

    private ConnectionPool() {
        connections = new ArrayBlockingQueue<>(5);
        semaphore = new Semaphore(5, true);

        // Lazy initialization
        for (int i = 0; i < 5; i++) {
            try {
                connections.add(new BufferedWriter(new FileWriter("src/main/resources/write.txt", true)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public CompletableFuture<BufferedWriter> getConnection() {
        CompletableFuture<BufferedWriter> future = new CompletableFuture<>();
        if (semaphore.tryAcquire()) {
            // If connection available -> return it ASAP
            try {
                BufferedWriter connection = connections.take();
                future.complete(connection);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        } else {
            // If not available -> wait until one is released
            CompletableFuture.runAsync(() -> {
                try {
                    BufferedWriter connection = connections.take();
                    future.complete(connection);
                } catch (InterruptedException e) {
                    future.completeExceptionally(e);
                }
            });
        }
        return future;
    }

    public void releaseConnection(BufferedWriter connection) {
        connections.add(connection);
        semaphore.release();
    }
}
