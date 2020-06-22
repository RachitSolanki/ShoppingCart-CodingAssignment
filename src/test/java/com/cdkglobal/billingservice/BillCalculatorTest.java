package com.cdkglobal.billingservice;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class BillCalculatorTest {

private HashMap<CustomerType,SlabTable> slabTableHashMap=new HashMap<>();

@Before
public void constructMap(){
        SlabTable slabTable = new SlabTable.Builder()
                .addNewSlab(0,5000,0)
                .addNewSlab(5000,10000,10)
                .addNewSlab(10000,Integer.MAX_VALUE,20)
                .build();

        slabTableHashMap.put(CustomerType.REGULAR,slabTable);


        SlabTable slabTable2 = new SlabTable.Builder()
                .addNewSlab(0,4000,10)
                .addNewSlab(4000,8000,15)
                .addNewSlab(8000,12000,20)
                .addNewSlab(12000,Integer.MAX_VALUE,30)
                .build();

        slabTableHashMap.put(CustomerType.PREMIUM,slabTable2);
}

@Test
public void regularCustomerTest() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(5000,billCalculator.calculateBillAmount(CustomerType.REGULAR,5000),0);
}

@Test
public void regularCustomerTestSecondSlab() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(9500,billCalculator.calculateBillAmount(CustomerType.REGULAR,10000),0);
}

@Test
public void regularCustomerTestLastSlab() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(13500,billCalculator.calculateBillAmount(CustomerType.REGULAR,15000),0);
}

@Test
public void premiumCustomerTest() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(3600,billCalculator.calculateBillAmount(CustomerType.PREMIUM,4000),0);
}

@Test
public void premiumCustomerTestSecondSlab() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(7000,billCalculator.calculateBillAmount(CustomerType.PREMIUM,8000),0);
}

@Test
public void premiumCustomerTestThirdSlab() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(10200,billCalculator.calculateBillAmount(CustomerType.PREMIUM,12000),0);
}

@Test
public void premiumCustomerTestLastSlab() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(15800,billCalculator.calculateBillAmount(CustomerType.PREMIUM,20000),0);
}


@Test
public void customerTestNegativeAmount() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(-20000,billCalculator.calculateBillAmount(CustomerType.PREMIUM,-20000),0);
}

@Test
public void customerTestZeroAmount() {
        BillCalculator billCalculator = new BillCalculator(slabTableHashMap);
        Assert.assertEquals(0,billCalculator.calculateBillAmount(CustomerType.PREMIUM,0),0);
}


}
