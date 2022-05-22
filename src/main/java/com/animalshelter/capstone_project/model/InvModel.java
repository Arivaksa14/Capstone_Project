package com.animalshelter.capstone_project.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.Scanner;

public class InvModel {

    public static final String BINARY_FILE = "inventory.dat";
    public static final String TXT_FILE = "Perishable.txt";

    public static boolean binaryFileHasData() {
        File binaryFile = new File(BINARY_FILE);
        return (binaryFile.exists() && binaryFile.length() >= 5L);
    }
    public static ObservableList<PerishableGoods> populateListFromTXTFile() {
        ObservableList<PerishableGoods> allPerishable = FXCollections.observableArrayList();
        String line;
        String[] parts;
        int itemNo;
        String category,productName, vendor, spec, expireDate;
        double price;

        try {
            Scanner fileScanner = new Scanner(new File(TXT_FILE));
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                parts = line.split("/t");
                itemNo = Integer.parseInt(parts[0]);
                category = parts[1];
                productName = parts[2];
                vendor = parts[3];
                price = Double.parseDouble(parts[4]);
                spec = parts[5];
                expireDate = parts[6];
                allPerishable.add(new PerishableGoods(itemNo,category,productName,vendor,price, spec, expireDate));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return allPerishable;
    }
    public static ObservableList<PerishableGoods> populateListFromBinaryFile() {
        ObservableList<PerishableGoods> allPerishable = FXCollections.observableArrayList();
        try {
            ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
            PerishableGoods[] array = (PerishableGoods[]) fileReader.readObject();
            for (PerishableGoods nl : array) {
                allPerishable.add(nl);
            }
            fileReader.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return allPerishable;
    }

    public static boolean writeDataToBinaryFile(ObservableList<PerishableGoods> allPerishableList) {
        PerishableGoods[] array = new PerishableGoods[allPerishableList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = allPerishableList.get(i);
        }
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
            fileWriter.writeObject(array);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
}