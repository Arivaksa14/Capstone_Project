package com.animalshelter.capstone_project.model;
import java.io.Serializable;
import java.text.NumberFormat;

public class PerishableGoods extends Inventory implements Comparable<Inventory>, Serializable {
    String mCategory, mSpec,mExpDate;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    public PerishableGoods(int itemNo, String category, String productName, String vendor, double price, String spec, String expireDate) {
        super(itemNo, productName, vendor, price);
        mCategory = category;
        mSpec = spec;
        mExpDate = expireDate;
    }
    public int compareTo(PerishableGoods o) {
    return super.compareTo(o);
    }
    @Override
    public String toString() {
        return "Item#: " + mItemNo +
                ", " + mCategory +
                ", " + mProductName +
                ", " + mVendor +
                ", " + currency.format(mPrice) +
                ", " + mSpec +
                ", Expiration Date: " + mExpDate;
    }
}
