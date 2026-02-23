package com.test.insuranceservice.datamodel;

import java.util.LinkedList;

public class Person {
    private String idNumber;
    private LinkedList<Insurance> insurances;

    public Person(String idNumber, LinkedList<Insurance> insurances) {
        this.idNumber = idNumber;
        this.insurances = insurances;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LinkedList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(LinkedList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void addInsurance(Insurance insurance) {
        this.insurances.add(insurance);
    }
}
