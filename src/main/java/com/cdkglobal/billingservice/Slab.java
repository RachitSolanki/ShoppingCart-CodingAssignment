package com.cdkglobal.billingservice;

public class Slab {

private int minAmount;
private int maxAmount;
private int discount;
private float maxDiscountAmount;

public Slab(int minAmount, int maxAmount, int discount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.discount = discount;

        if(this.maxAmount != Integer.MAX_VALUE)
                this.maxDiscountAmount = ((float)(maxAmount-minAmount)*discount)/100;
}

public int getMinAmount() {
        return minAmount;
}

public int getMaxAmount() {
        return maxAmount;
}

public int getDiscount() {
        return discount;
}

public float getMaxDiscountAmount() {
        return maxDiscountAmount;
}

public float calculateDiscount(float purchaseAmount) {

        if(maxAmount <= purchaseAmount ) {
                return maxDiscountAmount;
        } else if( minAmount < purchaseAmount &&
                   purchaseAmount < maxAmount ) {
                return ((purchaseAmount- minAmount )* discount)/100;
        }

        return 0;
}

}
