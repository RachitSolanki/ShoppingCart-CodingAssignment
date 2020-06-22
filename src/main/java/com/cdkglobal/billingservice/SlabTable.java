package com.cdkglobal.billingservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SlabTable {

private List<Slab> slabList;

public SlabTable() {
        this.slabList = new ArrayList<>();
}

private void sort() {
        this.slabList.sort(Comparator.comparingInt(Slab::getMinAmount));
}

public void addSlab(Slab slab) {
        this.slabList.add(slab);
}

public List<Slab> getSlabList() {
        return Collections.unmodifiableList(slabList);
}

public static class Builder {

private SlabTable slabTable;

public Builder() {
        this.slabTable = new SlabTable();
}

Builder addNewSlab(int minAmount, int maxAmount, int discount) {
        slabTable.addSlab(new Slab(minAmount,maxAmount,discount));
        return this;
}

SlabTable build() {
        slabTable.sort();
        return slabTable;
}

}

}
