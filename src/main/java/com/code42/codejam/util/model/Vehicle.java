package com.code42.codejam.util.model;

public class Vehicle {

    public Point position;
    public Point to;
    public Ride ride;

    public Vehicle(Point position, Point to) {
        this.position = position;
        this.to = to;
    }
}
