package com.solvd.laba.FinalClass;

import com.solvd.laba.Interfaces.IPrintInfo;

public final class DataBaseConfig implements IPrintInfo {
    private final String databaseUrl;
    private final int maxConnections;

    public DataBaseConfig(String databaseUrl, int maxConnections) {
        this.databaseUrl = databaseUrl;
        this.maxConnections = maxConnections;
    }

    public final String getDatabaseUrl() {
        return databaseUrl;
    }

    public final int getMaxConnections() {
        return maxConnections;
    }

    @Override
    public void printInfo() {
        System.out.println("Data Base information:");
        System.out.println(" URL: " + getDatabaseUrl() + " Max Connections: " + getMaxConnections());
    }

    // Rest of the class implementation
}
