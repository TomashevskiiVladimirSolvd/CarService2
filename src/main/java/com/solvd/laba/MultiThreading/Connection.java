package com.solvd.laba.MultiThreading;

public class Connection {
    private String connectionId;
    private boolean available;

    public Connection(String connectionId) {
        this.connectionId = connectionId;
        this.available = true;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
