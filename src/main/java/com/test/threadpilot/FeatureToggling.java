package com.test.threadpilot;

import org.springframework.stereotype.Component;

@Component
public class FeatureToggling {
    //On a typical Guidewire Implementation, this would use Runtime Properties
    private static boolean additionalFields = true;

    public static boolean isAdditionalFields() { return additionalFields; }
}