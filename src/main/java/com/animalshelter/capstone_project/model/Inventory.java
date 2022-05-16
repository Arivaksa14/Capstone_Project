package com.animalshelter.capstone_project.model;
import java.io.Serializable;
public abstract class Inventory implements Serializable {
    protected String mProductName;
    protected double mPrice;

    public Inventory(String productName, double price) {
        mProductName = productName;
        mPrice = price;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }
}
