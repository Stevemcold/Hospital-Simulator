package com.hospital.Application;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientTest {
    private Patient p = new Patient(new Condition("H"));
    private List<Drug> drugList = new ArrayList<>();

    @Test
    void getCondition() {
        assertEquals(new Condition("H").getInitial(), p.getCondition().getInitial());
    }

    @Test
    void treat() {
        p = new Patient(new Condition("F"));
        drugList.add(new Aspirin());
        p.treat(drugList);
        assertEquals(p.getCondition().getInitial(), new Condition("H").getInitial());
    }
}