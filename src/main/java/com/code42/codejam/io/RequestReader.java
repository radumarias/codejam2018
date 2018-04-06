package com.code42.codejam.io;

import com.code42.codejam.model.Point;
import com.code42.codejam.model.RequestModel;
import com.code42.codejam.model.Ride;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestReader {

    public RequestModel read(InputStream is) throws IOException {
        RequestModel model = new RequestModel();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        String[] items = line.split(" ");
        int i = 0;
        model.setRows(Integer.parseInt(items[i++]));
        model.setCols(Integer.parseInt(items[i++]));
        model.setVehicles(Integer.parseInt(items[i++]));
        model.setNumRides(Integer.parseInt(items[i++]));
        model.setBonus(Integer.parseInt(items[i++]));
        model.setSteps(Integer.parseInt(items[i++]));

        Ride ride;
        String[] vals;
        model.setRidesList(new Ride[model.getNumRides()]);
        for (int j = 0; j < model.getNumRides(); j++) {
            ride = new Ride();
            ride.setId(j);
            vals = br.readLine().split(" ");
            ride.setFrom(new Point(Integer.parseInt(vals[0]), Integer.parseInt(vals[1])));
            ride.setTo(new Point(Integer.parseInt(vals[2]), Integer.parseInt(vals[3])));
            ride.setEarliestStart(Integer.parseInt(vals[4]));
            ride.setLatestFinish(Integer.parseInt(vals[5]));
            ride.setDistance(Math.abs(ride.getFrom().getRow() - ride.getTo().getRow()) +
                    Math.abs(ride.getFrom().getCol() - ride.getTo().getCol()));
            model.getRidesList()[j] = ride;
        }

        return model;
    }
}
