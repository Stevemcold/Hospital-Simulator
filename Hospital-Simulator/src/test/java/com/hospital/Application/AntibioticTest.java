package com.hospital.Application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AntibioticTest {
    private Antibiotic an = new Antibiotic();
    private List<Drug> collateralList = new ArrayList<>();
    @Before
    public void setUp(){

    }

    @Test
    void apply() {
        Assert.assertEquals(new Condition("H").getInitial(), an.apply(new Condition("T")).getInitial());
        Assert.assertEquals(new Condition("D").getInitial(), an.apply(new Condition("D")).getInitial());
    }

    @Test
    void collateralEffect() {
        collateralList.add(new Insulin());
        Assert.assertEquals(new Condition("F").getInitial(), an.collateralEffect(collateralList, new Condition("H")).getInitial());
        Assert.assertEquals(new Condition("D").getInitial(), an.collateralEffect(collateralList, new Condition("D")).getInitial());
    }

}