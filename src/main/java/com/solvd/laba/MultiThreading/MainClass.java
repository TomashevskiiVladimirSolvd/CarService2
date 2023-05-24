package com.solvd.laba.MultiThreading;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.*;

public class MainClass {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 5; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        BufferedWriter connection = connectionPool.getConnection().get();
                        connection.write("This is First line of text");
                        connection.newLine();
                        connection.flush();
                        connectionPool.releaseConnection(connection);
                    } catch (InterruptedException | ExecutionException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter connection = connectionPool.getConnection().get();
                    connection.write("This is a second line.");
                    connection.newLine();
                    connection.flush();
                    connectionPool.releaseConnection(connection);
                } catch (InterruptedException | ExecutionException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter connection = connectionPool.getConnection().get();
                    connection.write("This is a third line.");
                    connection.newLine();
                    connection.flush();
                    connectionPool.releaseConnection(connection);
                } catch (InterruptedException | ExecutionException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }
}
