package com.hospital.Application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

class AntibioticTest {
    Antibiotic a;
    List<Drug> collateralList;
    @Before
    void setUp(){
        Antibiotic a = new Antibiotic();
        collateralList.add(new Insulin());
    }

    @Test
    void apply() {
        Assert.assertEquals("H", a.apply("T"));
        Assert.assertEquals("F", a.apply("F"));
    }

    @Test
    void collateralEffect() {
        Assert.assertEquals("F", a.collateralEffect(collateralList, "H"));
        Assert.assertEquals("F", a.collateralEffect(collateralList, "F"));
    }
}