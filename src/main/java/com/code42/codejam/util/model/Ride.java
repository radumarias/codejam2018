package com.code42.codejam.util.model;

public class Ride {

    private int id;

    private Point from;
    private Point to;
    private int earliestStart;
    private int latestFinish;
    private int distance;

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", earliestStart=" + earliestStart +
                ", latestFinish=" + latestFinish +
                ", distance=" + distance +
                '}';
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
