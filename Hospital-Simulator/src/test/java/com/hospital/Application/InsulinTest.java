package com.hospital.Application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InsulinTest {
    private Insulin i = new Insulin();
    private List<Drug> collateralList = new ArrayList<>();
    @Before
    public void setUp(){

    }

    @Test
    void apply() {
        Assert.assertEquals(new Condition("ID").getInitial(), i.apply(new Condition("D")).getInitial());
        Assert.assertEquals(new Condition("F").getInitial(), i.apply(new Condition("F")).getInitial());
    }

    @Test
    void collateralEffect() {
        collateralList.add(new Antibiotic());
        Assert.assertEquals(new Condition("F").getInitial(), i.collateralEffect(collateralList, new Condition("H")).getInitial());
        Assert.assertEquals(new Condition("F").getInitial(), i.collateralEffect(collateralList, new Condition("F")).getInitial());
    }


}