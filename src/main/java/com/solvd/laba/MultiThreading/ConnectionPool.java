package com.solvd.laba.MultiThreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConnectionPool {
    private BlockingQueue<BufferedWriter> connections;
    private Semaphore semaphore;

    private static ConnectionPool instance;

    private ConnectionPool() {
        connections = new ArrayBlockingQueue<>(5);
        semaphore = new Semaphore(5, true);

        // Lazy initialization
        IntStream.range(0, 5).forEach(i -> {
            try {
                connections.add(createBufferedWriter("src/main/resources/write.txt", true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private BufferedWriter createBufferedWriter(String filePath, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, append);
        return new BufferedWriter(fileWriter);
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
        try {
            connections.add(connection);
            connection.close(); // Close the connection after adding it back to the queue
        } catch (IOException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

}
