package com.hospital.Application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AspirinTest {
    private Aspirin a = new Aspirin();
    private List<Drug> collateralList = new ArrayList<>();
    @Before
    public void setUp(){

    }

    @Test
    void apply() {
        Assert.assertEquals(new Condition("H").getInitial(), a.apply(new Condition("F")).getInitial());
        Assert.assertEquals(new Condition("D").getInitial(), a.apply(new Condition("D")).getInitial());
    }

    @Test
    void collateralEffect() {
        collateralList.add(new Paracetamol());
        Assert.assertEquals(new Condition("X").getInitial(), a.collateralEffect(collateralList, new Condition("F")).getInitial());
        Assert.assertEquals(new Condition("D").getInitial(), a.collateralEffect(new ArrayList<>(), new Condition("D")).getInitial());
    }

}