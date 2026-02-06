package com.test.threadpilot;

import com.test.threadpilot.datamodel.Vehicle;

import java.util.LinkedList;

public class VehicleData {
    private LinkedList<Vehicle> vehicleData;

    public VehicleData() {
        vehicleData = new LinkedList<>();
        vehicleData.add(new Vehicle("ABC123", "Red", "Toyota", "Vios", 2012));
        vehicleData.add(new Vehicle("BBC123", "Blue", "Honda", "Civic", 2022));
        vehicleData.add(new Vehicle("CBC123", "Green", "Nissan", "Skyline", 2015));
        vehicleData.add(new Vehicle("DBC123", "Purple", "Kia", "Carnival", 2003));
    }

    public Vehicle getVehicleData(String registrationNumber) {
        for (Vehicle vehicle : vehicleData) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicleData(Vehicle vehicleData) {
        this.vehicleData.add(vehicleData);
    }
}
