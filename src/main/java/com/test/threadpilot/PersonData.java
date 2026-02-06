package com.test.threadpilot;

import com.test.threadpilot.datamodel.CarInsurance;
import com.test.threadpilot.datamodel.Insurance;
import com.test.threadpilot.datamodel.Person;
import com.test.threadpilot.datamodel.Vehicle;

import java.util.LinkedList;

public class PersonData {
    private LinkedList<Person> personData;

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
}
