package com.cdkglobal.billingservice;

import java.util.HashMap;

public class BillCalculator {

private HashMap<CustomerType,SlabTable> slabMap;

public BillCalculator(HashMap<CustomerType,SlabTable> slabMap) {
        this.slabMap = slabMap;
}

public float calculateBillAmount(CustomerType type, float purchaseAmount) {
        float billAmount=purchaseAmount;

        SlabTable slabTable = slabMap.get(type);
        for(Slab slab : slabTable.getSlabList())
                billAmount -= slab.calculateDiscount(purchaseAmount);

        return billAmount;
}

}
