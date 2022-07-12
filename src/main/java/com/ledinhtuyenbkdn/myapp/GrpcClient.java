package com.ledinhtuyenbkdn.myapp;

import com.ledinhtuyenbkdn.myapp.grpc.*;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GrpcClient {

    private String host;

    private int port;

    private Channel channel;

    private RouteGuideGrpc.RouteGuideStub asyncStub;

    private RouteGuideGrpc.RouteGuideBlockingStub blockingStub;

    public GrpcClient(String host, int port) {
        this.host = host;
        this.port = port;
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        System.out.println("Init grpc client at: " + this.host + ":" + this.port);
        this.asyncStub = RouteGuideGrpc.newStub(channel);
        this.blockingStub = RouteGuideGrpc.newBlockingStub(channel);
    }

    public void getFeature(int lat, int lon) {
        Point request = Point.newBuilder().setLatitude(lat).setLongitude(lon).build();
        try {
            Feature feature = blockingStub.getFeature(request);
            System.out.println(feature);
        } catch (StatusRuntimeException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void listFeatures(int lowLat, int lowLon, int hiLat, int hiLon) {
        Rectangle request =
                Rectangle.newBuilder()
                        .setLo(Point.newBuilder().setLatitude(lowLat).setLongitude(lowLon).build())
                        .setHi(Point.newBuilder().setLatitude(hiLat).setLongitude(hiLon).build()).build();
        Iterator<Feature> features;
        try {
            features = blockingStub.listFeatures(request);
            while (features.hasNext()) {
                System.out.println(features.next());
            }
        } catch (StatusRuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    public void recordRoute() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<RouteSummary> responseObserver = new StreamObserver<RouteSummary>() {
            @Override
            public void onNext(RouteSummary routeSummary) {
                System.out.println("Received route summary from server: " + routeSummary.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };

        StreamObserver<Point> requestObserver = asyncStub.recordRoute(responseObserver);

        for (int i = 0; i < 10; i++) {
            try {
                requestObserver.onNext(Point.newBuilder().setLatitude(i).setLongitude(i).build());
                Thread.sleep(1000);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return;
                }
            } catch (InterruptedException e) {
                requestObserver.onError(e);
            }
        }

        requestObserver.onCompleted();
        finishLatch.await(1, TimeUnit.MINUTES);
    }

    public void routeChat() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<RouteNote> responseObserver = new StreamObserver<RouteNote>() {
            @Override
            public void onNext(RouteNote routeNote) {
                System.out.println("Received route note from server: " + routeNote.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };

        StreamObserver<RouteNote> requestObserver = asyncStub.routeChat(responseObserver);

        for (int i = 0; i < 10; i++) {
            try {
                requestObserver.onNext(
                        RouteNote.newBuilder()
                                .setMessage("message " + i)
                                .setLocation(Point.newBuilder().setLatitude(i).setLongitude(i).build())
                                .build());
                Thread.sleep(1000);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return;
                }
            } catch (InterruptedException e) {
                requestObserver.onError(e);
            }
        }

        requestObserver.onCompleted();
        finishLatch.await(1, TimeUnit.MINUTES);
    }

    public static void main(String[] args) throws InterruptedException {
        GrpcClient grpcClient = new GrpcClient("localhost", 8080);
        grpcClient.getFeature(1, 1);
        grpcClient.listFeatures(0, 0, 3, 3);
        grpcClient.recordRoute();
        grpcClient.routeChat();
    }
}
