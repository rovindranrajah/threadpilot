package com.test.threadpilot.datamodel;

public class Vehicle {

    private String registrationNumber;
    private String colour;
    private String make;
    private String modal;
    private Integer year;

    public Vehicle (String registrationNumber, String colour, String make, String modal, Integer year) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
        this.make = make;
        this.modal = modal;
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public String getMake() {
        return make;
    }

    public String getModal() {
        return modal;
    }

    public Integer getYear() {
        return year;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
