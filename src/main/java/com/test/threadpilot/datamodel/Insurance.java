package com.test.threadpilot.datamodel;

public class Insurance {
    private String insuranceType;
    private Integer cost;

    public Insurance(String insuranceType, Integer cost) {
        this.insuranceType = insuranceType;
        this.cost = cost;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
