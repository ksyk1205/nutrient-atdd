package com.example.nutrient.study;

public class PathResponse {
    private int distance;
    private int duration;
    private int fare;

    public PathResponse(int distance, int duration, int fare) {
        this.distance = distance;
        this.duration = duration;
        this.fare = fare;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public int getFare() {
        return fare;
    }
}
