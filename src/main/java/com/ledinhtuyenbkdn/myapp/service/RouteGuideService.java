package com.ledinhtuyenbkdn.myapp.service;

import com.ledinhtuyenbkdn.myapp.grpc.*;
import io.grpc.stub.StreamObserver;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RouteGuideService extends RouteGuideGrpc.RouteGuideImplBase {

    private final Collection<Feature> features = new ArrayList<>();
    private final ConcurrentMap<Point, List<RouteNote>> routeNotes =
            new ConcurrentHashMap<Point, List<RouteNote>>();

    public RouteGuideService() {
        Point location1 = Point.newBuilder().setLatitude(1).setLongitude(1).build();
        Feature feature1 = Feature.newBuilder().setName("feature one").setLocation(location1).build();

        Point location2 = Point.newBuilder().setLatitude(2).setLongitude(2).build();
        Feature feature2 = Feature.newBuilder().setName("feature one").setLocation(location2).build();

        this.features.add(feature1);
        this.features.add(feature2);
    }

    @Override
    public void getFeature(Point request, StreamObserver<Feature> responseObserver) {
        System.out.println("Request to get feature");
        responseObserver.onNext(checkFeature(request));
        responseObserver.onCompleted();
    }

    private Feature checkFeature(Point location) {
        for (Feature feature : features) {
            if (feature.getLocation().getLatitude() == location.getLatitude()
                    && feature.getLocation().getLongitude() == location.getLongitude()) {
                return feature;
            }
        }
        // No feature was found, return an unnamed feature.
        return Feature.newBuilder().setName("").setLocation(location).build();
    }

    @Override
    public void listFeatures(Rectangle request, StreamObserver<Feature> responseObserver) {
        System.out.println("Request to get list features");
        int left = min(request.getLo().getLongitude(), request.getHi().getLongitude());
        int right = max(request.getLo().getLongitude(), request.getHi().getLongitude());
        int top = max(request.getLo().getLatitude(), request.getHi().getLatitude());
        int bottom = min(request.getLo().getLatitude(), request.getHi().getLatitude());

        for (Feature feature : features) {
            int lat = feature.getLocation().getLatitude();
            int lon = feature.getLocation().getLongitude();
            if (lon >= left && lon <= right && lat >= bottom && lat <= top) {
                responseObserver.onNext(feature);
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Point> recordRoute(StreamObserver<RouteSummary> responseObserver) {
        System.out.println("Request to record route");
        return new StreamObserver<Point>() {
            int pointCount;
            int featureCount;
            int distance;
            Point previous;
            long startTime = System.nanoTime();

            @Override
            public void onNext(Point point) {
                pointCount++;
                featureCount++;
                // For each point after the first, add the incremental distance from the previous point
                // to the total distance value.
                if (previous != null) {
                    distance += calcDistance(previous, point);
                }
                previous = point;
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Encountered error in recordRoute");
            }

            @Override
            public void onCompleted() {
                long seconds = NANOSECONDS.toSeconds(System.nanoTime() - startTime);
                responseObserver.onNext(
                        RouteSummary.newBuilder()
                                .setPointCount(pointCount)
                                .setFeatureCount(featureCount)
                                .setDistance(distance)
                                .setElapsedTime((int) seconds)
                                .build()
                );
                responseObserver.onCompleted();
            }
        };
    }

    private static int calcDistance(Point start, Point end) {
        int r = 6371000; // earth radius in meters
        double lat1 = toRadians(start.getLatitude());
        double lat2 = toRadians(end.getLatitude());
        double lon1 = toRadians(start.getLongitude());
        double lon2 = toRadians(end.getLongitude());
        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = sin(deltaLat / 2) * sin(deltaLat / 2)
                + cos(lat1) * cos(lat2) * sin(deltaLon / 2) * sin(deltaLon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return (int) (r * c);
    }

    @Override
    public StreamObserver<RouteNote> routeChat(StreamObserver<RouteNote> responseObserver) {
        System.out.println("Request to route chat");
        return new StreamObserver<RouteNote>() {
            @Override
            public void onNext(RouteNote routeNote) {
                // client stream data to server
                // then server process date and response
                RouteNote responseNote = RouteNote.newBuilder()
                        .setLocation(routeNote.getLocation())
                        .setMessage("Message from server: " + routeNote.getMessage())
                        .build();

                responseObserver.onNext(responseNote);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Encountered error in recordRoute");
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
