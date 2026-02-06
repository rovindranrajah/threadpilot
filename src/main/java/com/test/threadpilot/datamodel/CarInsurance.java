package com.test.threadpilot.datamodel;

public class CarInsurance extends Insurance{
    private String regNo;

    public CarInsurance(String insuranceType, Integer cost, String regNo) {
        super(insuranceType, cost);
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
