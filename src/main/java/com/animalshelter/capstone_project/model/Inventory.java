package com.animalshelter.capstone_project.model;
import java.io.Serializable;
public abstract class Inventory implements Serializable, Comparable<Inventory>{
    protected String mProductName,mVendor;
    protected int mItemNo;
    protected double mPrice;

    public Inventory(int itemNo, String productName, String vendor, double price) {
        mItemNo = itemNo;
        mProductName = productName;
        mVendor = vendor;
        mPrice = price;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getVendor() {
        return mVendor;
    }

    public void setVendor(String vendor) {
        mVendor = vendor;
    }

    public int getItemNo() {
        return mItemNo;
    }

    public void setItemNo(int itemNo) {
        mItemNo = itemNo;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }
    public int compareTo(Inventory o) {
        int itemNoComp = this.mItemNo - o.mItemNo;
        if (itemNoComp!=0) return itemNoComp;

        int nameComp = this.mProductName.compareToIgnoreCase(o.mProductName);
        if (nameComp!=0) return nameComp;

        int vendorComp = this.mVendor.compareToIgnoreCase(o.mVendor);
        if (vendorComp!=0) return vendorComp;

        return Double.compare(this.mPrice,o.mPrice);
    }
}
