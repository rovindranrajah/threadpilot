package com.test.insuranceservice;

import com.test.insuranceservice.dto.*;
import com.test.insuranceservice.datamodel.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InsuranceController {

    private final PersonData personDatabase = new PersonData();
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/insurance/{idNumber}")
    public ResponseEntity<PersonInsuranceDTO> getInsuranceInformation(@PathVariable("idNumber") String idNumber) {
        Person person = personDatabase.getPersonData(idNumber);

        if (person == null) {
            return ResponseEntity.notFound().build();
        }

        PersonInsuranceDTO response = new PersonInsuranceDTO();
        response.setIdNumber(person.getIdNumber());
        List<InsuranceDTO> dtoList = new ArrayList<>();

        for (Insurance insurance : person.getInsurances()) {
            double actualCost = getActualInsuranceCost(person, insurance, personDatabase);

            if (insurance instanceof CarInsurance) {
                CarInsurance carIns = (CarInsurance) insurance;
                CarInsuranceDTO carDto = new CarInsuranceDTO();
                carDto.setInsuranceType(carIns.getInsuranceType());
                carDto.setCost(actualCost);
                carDto.setRegNo(carIns.getRegNo());

                carDto.setVehicleInfo(fetchVehicle(carIns.getRegNo()));

                dtoList.add(carDto);
            } else {
                InsuranceDTO regularDto = new InsuranceDTO();
                regularDto.setInsuranceType(insurance.getInsuranceType());
                regularDto.setCost(actualCost);
                dtoList.add(regularDto);
            }
        }

        response.setInsurances(dtoList);
        return ResponseEntity.ok(response);
    }

    private VehicleDTO fetchVehicle(String registrationNumber) {

        final String uri = "http://localhost:8081/vehicle/" + registrationNumber;
        try {
            return restTemplate.getForObject(uri, VehicleDTO.class);
        } catch (Exception e) {
            return null;
        }
    }

    private double getActualInsuranceCost(Person person, Insurance insurance, PersonData personDatabase) {

        if (personDatabase.isEligibleForCampaignDiscount(person)) {
            return insurance.getCost() * ((100 - personDatabase.getBusinessCampaignDiscount()) / 100);
        }
        return insurance.getCost();
    }
}