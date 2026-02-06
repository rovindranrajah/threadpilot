package com.test.threadpilot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    VehicleData vehicleDatabase = new VehicleData();
    FeatureToggling toggle;

    @GetMapping("/vehicle/{registrationNumber}")
    public String getVehicleInformation(@PathVariable("registrationNumber") String registrationNumber) {
        var vehicle = vehicleDatabase.getVehicleData(registrationNumber);
        if(vehicle != null){
            return "Registration number: " + vehicle.getRegistrationNumber()
                    + "<br>Colour: " + vehicle.getColour()
                    + (toggle.isAdditionalFields() ? (
                     "<br>Make: " + vehicle.getMake()
                    + "<br>Modal: " + vehicle.getModal()
                    + "<br>Year: " + vehicle.getYear()) : "<br>");
        }

        return "Vehicle Data does not exist";
    }


}
