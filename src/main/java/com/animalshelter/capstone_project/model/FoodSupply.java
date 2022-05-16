package com.animalshelter.capstone_project.model;
import java.io.Serializable;
public class FoodSupply extends Inventory implements Serializable {
    private String mExpirationDate;
    public FoodSupply(String productName, double price, String expirationDate) {
        super(productName, price);
        mExpirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "FoodSupply{" +
                "mExpirationDate='" + mExpirationDate + '\'' +
                ", mProductName='" + mProductName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
