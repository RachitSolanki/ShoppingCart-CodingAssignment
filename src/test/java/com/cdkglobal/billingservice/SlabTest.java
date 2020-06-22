package com.cdkglobal.billingservice;

import org.junit.Assert;
import org.junit.Test;

public class SlabTest {

@Test
public void slabDiscountTest_1() {
        Slab slab = new Slab(5000,10000,10);
        Assert.assertEquals(500,slab.calculateDiscount(15000),0);
}

@Test
public void slabDiscountTest_2() {
        Slab slab = new Slab(10000,Integer.MAX_VALUE,20);
        Assert.assertEquals(1000,slab.calculateDiscount(15000),0);
}

}
