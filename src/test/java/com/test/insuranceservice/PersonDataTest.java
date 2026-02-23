package com.test.insuranceservice;

import com.test.insuranceservice.datamodel.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDataTest {

    private PersonData personData;

    @BeforeEach
    void setUp() {
        personData = new PersonData();
    }

    @Test
    void testGetPersonData_Success() {
        Person person = personData.getPersonData("555555");
        assertNotNull(person);
        assertEquals("555555", person.getIdNumber());
        assertEquals(3, person.getInsurances().size());
    }

    @Test
    void testIsEligibleForCampaignDiscount_TrueForTargetedCustomers() {
        Person person = personData.getPersonData("555555");
        assertTrue(personData.isEligibleForCampaignDiscount(person));
    }

    @Test
    void testIsEligibleForCampaignDiscount_FalseForOtherCustomers() {
        Person person = personData.getPersonData("655555");
        assertFalse(personData.isEligibleForCampaignDiscount(person));
    }
}