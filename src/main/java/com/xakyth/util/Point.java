package com.xakyth.util;

public class Point {
    public double x;
    public double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x: %s, y: %s", this.x, this.y);
    }

}
