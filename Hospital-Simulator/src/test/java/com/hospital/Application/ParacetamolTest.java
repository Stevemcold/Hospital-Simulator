package com.hospital.Application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParacetamolTest {
    private Paracetamol p = new Paracetamol();
    private List<Drug> collateralList = new ArrayList<>();
    @Before
    public void setUp(){

    }

    @Test
    void apply() {
        Assert.assertEquals(new Condition("H").getInitial(), p.apply(new Condition("F")).getInitial());
        Assert.assertEquals(new Condition("D").getInitial(), p.apply(new Condition("D")).getInitial());
    }

    @Test
    void collateralEffect() {
        collateralList.add(new Aspirin());
        Assert.assertEquals(new Condition("X").getInitial(), p.collateralEffect(collateralList, new Condition("F")).getInitial());
        Assert.assertEquals(new Condition("T").getInitial(), p.collateralEffect(new ArrayList<>(), new Condition("T")).getInitial());
    }

}