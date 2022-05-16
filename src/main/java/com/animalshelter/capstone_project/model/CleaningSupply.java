package com.animalshelter.capstone_project.model;
import java.io.Serializable;
public class CleaningSupply extends Inventory implements Serializable {
    public CleaningSupply(String productName, double price) {
        super(productName, price);
    }

    @Override
    public String toString() {
        return "CleaningSupply{" +
                "mProductName='" + mProductName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
