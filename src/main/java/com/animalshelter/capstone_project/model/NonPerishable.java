package com.animalshelter.capstone_project.model;
import java.io.Serializable;
import java.text.NumberFormat;

public class NonPerishable extends Inventory implements Comparable<Inventory>, Serializable {
    String mCategory, mSize;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    public NonPerishable(int itemNo, String category, String productName, String vendor, double price, String size) {
        super(itemNo, productName, vendor, price);
        mCategory = category;
        mSize = size;
    }

    public int compareTo(NonPerishable o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return "Item#: " + mItemNo +
                ", " + mCategory +
                ", " + mProductName +
                ", " + mVendor +
                ", " + currency.format(mPrice) +
                ", " + mSize;
    }
}
