package com.animalshelter.capstone_project.model;
import java.io.Serializable;
public class PerishableGoods extends Inventory implements Comparable<Inventory>, Serializable {
    String mCategory, mSpec,mExpDate;

    public PerishableGoods(int itemNo, String category, String productName, String vendor, double price, String spec, String expireDate) {
        super(itemNo, productName, vendor, price);
        mCategory = category;
        mSpec = spec;
        mExpDate = expireDate;
    }

    public int compareTo(PerishableGoods o) {
    return super.compareTo(o);
    }
}
