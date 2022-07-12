package com.ledinhtuyenbkdn.myapp;

public class Main {

    public static void main(String[] args) throws Exception {
        GrpcServer grpcServer = new GrpcServer(8080);
        grpcServer.start();
        grpcServer.blockUntilShutdown();
    }
}
