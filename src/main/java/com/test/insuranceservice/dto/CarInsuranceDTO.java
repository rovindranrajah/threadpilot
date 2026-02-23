package com.test.insuranceservice.dto;

public class CarInsuranceDTO extends InsuranceDTO {
    private String regNo;
    private VehicleDTO vehicleInfo;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public VehicleDTO getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleDTO vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
}
