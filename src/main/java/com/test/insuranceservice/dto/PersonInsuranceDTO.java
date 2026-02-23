package com.test.insuranceservice.dto;

import java.util.List;

public class PersonInsuranceDTO {
    private String idNumber;
    private List<InsuranceDTO> insurances;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<InsuranceDTO> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<InsuranceDTO> insurances) {
        this.insurances = insurances;
    }
}
