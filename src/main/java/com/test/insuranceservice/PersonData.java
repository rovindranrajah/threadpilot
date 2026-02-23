package com.test.insuranceservice;

import com.test.insuranceservice.datamodel.CarInsurance;
import com.test.insuranceservice.datamodel.Insurance;
import com.test.insuranceservice.datamodel.Person;

import java.util.Arrays;
import java.util.LinkedList;

public class PersonData {
    private LinkedList<Person> personData;
    private final LinkedList <String> campaignDiscountCustomers = new LinkedList<>(Arrays.asList("555555", "111111"));
    private final double businessCampaignDiscount = 20;

    public PersonData() {
        LinkedList<Insurance> insuranceData = new LinkedList<>();
        personData = new LinkedList<>();

        insuranceData.add(new Insurance("Pet Insurance", 10));
        insuranceData.add(new Insurance("Personal Health Insurance", 20));
        insuranceData.add(new CarInsurance("Car Insurance", 30, "ABC123"));
        personData.add(new Person("555555", insuranceData));

        insuranceData = new LinkedList<>();
        insuranceData.add(new Insurance("Pet Insurance", 10));
        insuranceData.add(new Insurance("Personal Health Insurance", 20));
        personData.add(new Person("655555", insuranceData));


        insuranceData = new LinkedList<>();
        insuranceData.add(new Insurance("Pet Insurance", 10));
        insuranceData.add(new CarInsurance("Car Insurance", 30, "BBC123"));
        personData.add(new Person("552455", insuranceData));

        insuranceData = new LinkedList<>();
        insuranceData.add(new Insurance("Personal Health Insurance", 20));
        insuranceData.add(new CarInsurance("Car Insurance", 30, "CBC123"));
        personData.add(new Person("666666", insuranceData));

        insuranceData = new LinkedList<>();
        insuranceData.add(new CarInsurance("Car Insurance", 30, "DBC123"));
        personData.add(new Person("111111", insuranceData));
    }

    public Person getPersonData(String idNumber) {
        for (Person person : personData) {
            if (person.getIdNumber().equals(idNumber)) {
                return person;
            }
        }
        return null;
    }

    public void addPersonData(Person personData) {
        this.personData.add(personData);
    }

    public boolean isEligibleForCampaignDiscount(Person person) {
        return campaignDiscountCustomers.contains(person.getIdNumber());
    }

    public double getBusinessCampaignDiscount() {
        return businessCampaignDiscount;
    }
}
