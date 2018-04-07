package com.code42.codejam.util.model;

import java.util.Arrays;

public class RequestModel {

    private int rows;
    private int cols;
    private int vehicles;
    private int numRides;
    private int bonus;
    private int steps;
    private Ride[] ridesList;

    public RequestModel() {
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    public int getNumRides() {
        return numRides;
    }

    public void setNumRides(int numRides) {
        this.numRides = numRides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Ride[] getRidesList() {
        return ridesList;
    }

    public void setRidesList(Ride[] ridesList) {
        this.ridesList = ridesList;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "rows=" + rows +
                ", cols=" + cols +
                ", vehicles=" + vehicles +
                ", numRides=" + numRides +
                ", bonus=" + bonus +
                ", steps=" + steps +
                ", ridesList=" + Arrays.toString(ridesList) +
                '}';
    }
}
