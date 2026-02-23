package com.test.insuranceservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InsuranceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetInsuranceInformation_ReturnsData() {
        ResponseEntity<String> response = restTemplate.getForEntity("/insurance/555555", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetInsuranceInformation_NotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/insurance/INVALID", String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}