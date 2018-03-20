package org.example;

import org.apache.cassandra.thrift.CassandraServer;

public class MainClass {

    public static void main(String[] args) {
        run();
    }

    static void run() {
        new CassandraServer();
        System.out.println("Ran successfully");
    }
}