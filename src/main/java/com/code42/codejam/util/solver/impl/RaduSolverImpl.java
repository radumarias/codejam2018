package com.code42.codejam.util.solver.impl;

import com.code42.codejam.util.Utils;
import com.code42.codejam.util.io.SolutionWriter;
import com.code42.codejam.util.model.Point;
import com.code42.codejam.util.model.RequestModel;
import com.code42.codejam.util.model.Ride;
import com.code42.codejam.util.model.Vehicle;
import com.code42.codejam.util.solver.Solver;

import java.util.*;

public class RaduSolverImpl implements Solver {
    @Override
    public void solve(RequestModel requestModel, SolutionWriter writer) {

        List<Ride> ridesByDistance = Arrays.asList(requestModel.getRidesList());
        Collections.sort(ridesByDistance, (o1, o2) -> {
            int cost1 = o1.getDistance() - (o1.getFrom().getRow() + o1.getFrom().getCol());
            int cost2 = o2.getDistance() - (o2.getFrom().getRow() + o2.getFrom().getCol());

            return -(cost2 - cost1);
        });
        ridesByDistance = new ArrayList<>(ridesByDistance);

        List<Ride> ridesByTime = Arrays.asList(requestModel.getRidesList());
        Collections.sort(ridesByTime, (o1, o2) -> o2.getEarliestStart() - o1.getEarliestStart());

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < requestModel.getVehicles(); i++) {
            vehicles.add(new Vehicle(new Point(0, 0), null));
        }

        Set<Vehicle> free = new HashSet<>(vehicles);
        Set<Vehicle> busy = new HashSet<>();

        Map<Vehicle, Set<Ride>> solution = new HashMap<>();

        for (int step = 0; step < requestModel.getSteps(); step++) {
            if (free.size() != 0) {
                for (Iterator<Ride> iterator = ridesByDistance.iterator(); iterator.hasNext(); ) {
                    Ride ride = iterator.next();

                    List<Vehicle> closestCars = new ArrayList<>(free);
                    Collections.sort(closestCars, (o1, o2) -> Utils.distance(o2.position, ride.getFrom()) - Utils.distance(o1.position, ride.getFrom()));
                    Vehicle closest = closestCars.remove(0);
                    closest.ride = ride;
                    closest.to = ride.getFrom();
                    free.remove(closest);
                    busy.add(closest);

                    iterator.remove();
                }
            }

            // step
            for (Vehicle vehicle : vehicles) {
                if (vehicle.to != null) {
                    // in move
                    if (vehicle.position.getRow() < vehicle.to.getRow()) {
                        vehicle.position.setRow(vehicle.position.getRow() + 1);
                    } else {
                        vehicle.position.setCol(vehicle.position.getCol() + 1);
                    }
                }

                if (Objects.equals(vehicle.position, vehicle.to)) {
                    if (vehicle.ride != null) {
                        if (vehicle.position.equals(vehicle.ride.getFrom())) {
                            // at start, check if we can start ride
                            if (vehicle.ride.getEarliestStart() <= step) {
                                vehicle.to = vehicle.ride.getTo();
                            }
                        } else if (vehicle.position.equals(vehicle.ride.getTo())) {
                            // at destination, add solution
                            solution.getOrDefault(vehicle, new HashSet<>()).add(vehicle.ride);
                        }
                    }
                    // free vehicle
                    vehicle.to = null;
                    vehicle.ride = null;
                    busy.remove(vehicle);
                    free.add(vehicle);
                }
            }
        }
    }
}
