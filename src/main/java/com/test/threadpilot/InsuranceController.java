package com.test.threadpilot;

import com.test.threadpilot.datamodel.CarInsurance;
import com.test.threadpilot.datamodel.Insurance;
import com.test.threadpilot.datamodel.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InsuranceController {

    PersonData personDatabase = new PersonData();

    @GetMapping("/insurance/{idNumber}")
    public String getInsuranceInformation(@PathVariable("idNumber") String idNumber) {

        var person = personDatabase.getPersonData(idNumber);
        if(person != null){
            String insuranceData = "";
            for(Insurance insurance : person.getInsurances()){
                if (insurance instanceof CarInsurance){
                    insuranceData += insurance.getInsuranceType();
                    insuranceData += " Cost: $";
                    insuranceData += insurance.getCost();
                    insuranceData += "<br>";
                    insuranceData += getVehicle(((CarInsurance) insurance).getRegNo());
                    insuranceData += "<br>";
                } else {
                    insuranceData += insurance.getInsuranceType();
                    insuranceData += " Cost: $";
                    insuranceData += insurance.getCost();
                    insuranceData += "<br>";
                }

            }
            return "ID number: " + person.getIdNumber()
                    + "<br>Insurance: <br>" + insuranceData;
        }

        return "Person Data does not exist";
    }

    private String getVehicle(String registrationNumber)
    {
        final String uri = "http://localhost:8080/vehicle/";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri + registrationNumber, String.class);
    }
}
