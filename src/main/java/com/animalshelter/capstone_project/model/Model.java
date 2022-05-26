package com.animalshelter.capstone_project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Scanner;

    /**
     * The <code>Model</code> class represents the business logic (data and calculations) of the application.
     * In the Nobel Peace Prize Laureates app, it either loads laureates from a CSV file (first load) or a binary file (all
     * subsequent loads).  It is also responsible for saving data to a binary file.
     *
     * @author Michael Paulding
     * @version 1.0
     */
    public class Model {

        public static final String BINARY_FILE_ANIMALS = "Animals.dat";
        public static final String CSV_FILE_ANIMALS = "NewAnimals.csv";
        public static final String BINARY_FILE_MEDICAL_RECORD= "MedicalRecord.dat";
        public static final String CSV_FILE_MEDICAL_RECORD = "NewMedicalRecord.csv";
        public static final String BINARY_FILE_PERISHABLE = "Perishable.dat";
        public static final String TXT_FILE_PERISHABLE = "Perishable.txt";
        public static final String BINARY_FILE_NON_PERISHABLE = "NonPerishable.dat";
        public static final String TXT_FILE_NON_PERISHABLE = "NonPerishable.txt";
        public static final String BINARY_FILE_VOLUNTEER = "volunteer.dat";
        public static final String CSV_VOLUNTEER_FILE = "volunteerStartToImport.csv";

        /**
         * Determines whether the binary file exists and has data (size/length > 5L bytes).
         * @return True if the binary file exists and has data, false otherwise.
         */
        public static boolean binaryFileHasData(String binaryFileName)
        {
            File binaryFile = new File(binaryFileName);
            //an empty file is 4 bytes so:
            return (binaryFile.exists() && binaryFile.length() > 4L);
        }

        /**
         * Populates the list of all new animals from the binary file. This will only be called once, the first time the app
         * loaded to seed initial data from the CSV file.  All subsequent loads will be extracted from
         * the binary file.be called everytime the application loads,
         * @return The list of all animals populated from the CSV file
         */
        public static ObservableList<CatDog> populateAnimalsListFromCSVFile()
        {
            ObservableList<CatDog> allAnimals = FXCollections.observableArrayList();
            String animalName;
            String animalType;
            String animalGender;
            String animalAgeCat;
            String indoorOrOutdoor;
            String trained;
            String goodWithOtherAnimals;
            String active;

            String line;
            String[] parts;

            try {
                Scanner fileScanner = new Scanner(new File(CSV_FILE_ANIMALS));
                //loop through the file, skip header
                fileScanner.nextLine();
                while(fileScanner.hasNextLine()) {

                    line = fileScanner.nextLine();
                    parts = line.split(",");
                    animalName = parts[0];
                    animalType = parts[1];
                    animalGender = parts[2];
                    animalAgeCat = parts[3];
                    indoorOrOutdoor = parts[4];
                    trained = parts[5];
                    goodWithOtherAnimals = parts[6];
                    active = parts[7];
                    allAnimals.add(new CatDog(animalName,animalType,animalGender,animalAgeCat, indoorOrOutdoor, trained, goodWithOtherAnimals, active));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allAnimals;
        }

        public static ObservableList<MedicalRecord> populateMedicalRecordsListFromCSVFile()
        {
            ObservableList<MedicalRecord> allMedicalRecords = FXCollections.observableArrayList();
            String animalName;
            String animalType;
            String animalGender;
            String animalAgeCat;
            String declawed;
            String healthIssues;
            String spayedOrNeutered;
            String vaccinated;

            String line;
            String[] parts;

            try {
                Scanner fileScanner = new Scanner(new File(CSV_FILE_MEDICAL_RECORD));
                //loop through the file, skip header
                fileScanner.nextLine();
                while(fileScanner.hasNextLine()) {

                    line = fileScanner.nextLine();
                    parts = line.split(",");
                    animalName = parts[0];
                    animalType = parts[1];
                    animalGender = parts[2];
                    animalAgeCat = parts[3];
                    declawed = parts[4];
                    healthIssues = parts[5];
                    spayedOrNeutered = parts[6];
                    vaccinated = parts[7];
                    allMedicalRecords.add(new MedicalRecord(animalName,animalType,animalGender,animalAgeCat, declawed, healthIssues, spayedOrNeutered, vaccinated));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allMedicalRecords;
        }

        /**
         * Populates the list of all laureates from the binary file. This will be called everytime the application loads,
         * other than the very first time, since it needs initial data from CSV.
         * @return The list of all laureates populated from the binary file
         */
        public static ObservableList<CatDog> populateAnimalsListFromBinaryFile()
        {
            ObservableList<CatDog> allAnimals = FXCollections.observableArrayList();
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE_ANIMALS));

                CatDog[] array = (CatDog[]) fileReader.readObject();
                for (CatDog nl: array)
                    allAnimals.add(nl);
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allAnimals;
        }

        public static ObservableList<MedicalRecord> populateMedicalRecordsListFromBinaryFile()
        {
            ObservableList<MedicalRecord> allMedicalRecords = FXCollections.observableArrayList();
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE_MEDICAL_RECORD));

                MedicalRecord[] array = (MedicalRecord[]) fileReader.readObject();
                for (MedicalRecord mr: array)
                    allMedicalRecords.add(mr);
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allMedicalRecords;
        }

        /**
         * Saves the list of all animals to the binary file. This will be called each time the application stops,
         * which occurs when the user exits/closes the app.  Note this method is called in the View, by the controller,
         * during the stop() method.
         * @return True if the data were saved to the binary file successfully, false otherwise.
         */
        public static boolean writeDataToAnimalsBinaryFile(ObservableList<CatDog> allAnimalsList)
        {
            CatDog[] arrayAnimals = new CatDog[allAnimalsList.size()];
            for (int i = 0; i < arrayAnimals.length; i++) {
                arrayAnimals[i] = allAnimalsList.get(i);
            }
            try {
                ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_ANIMALS));
                fileWriter.writeObject(arrayAnimals);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
            return true;
        }
        public static boolean writeDataToMedicalRecordsBinaryFile(ObservableList<MedicalRecord> allMedicalRecordsList)
        {
            MedicalRecord[] arrayMedicalRecords = new MedicalRecord[allMedicalRecordsList.size()];
            for (int i = 0; i < arrayMedicalRecords.length; i++) {
                arrayMedicalRecords[i] = allMedicalRecordsList.get(i);
            }
            try {
                ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_MEDICAL_RECORD));
                fileWriter.writeObject(arrayMedicalRecords);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
            return true;
        }

        public static boolean PGBinaryFileHasData() {
            File binaryFile = new File(BINARY_FILE_PERISHABLE);
            return (binaryFile.exists() && binaryFile.length() >= 5L);
        }
        public static ObservableList<PerishableGoods> PGListFromTXTFile() {
            ObservableList<PerishableGoods> allPG = FXCollections.observableArrayList();
            String line;
            String[] parts;
            int itemNo;
            String category,productName, vendor, spec, expireDate;
            double price;

            try {
                Scanner fileScanner = new Scanner(new File(TXT_FILE_PERISHABLE));
                fileScanner.nextLine();
                while (fileScanner.hasNextLine()) {
                    line = fileScanner.nextLine();
                    parts = line.split("\t");
                    itemNo = Integer.parseInt(parts[0]);
                    category = parts[1];
                    productName = parts[2];
                    vendor = parts[3];
                    price = Double.parseDouble(parts[4]);
                    spec = parts[5];
                    expireDate = parts[6];
                    allPG.add(new PerishableGoods(itemNo,category,productName,vendor,price, spec, expireDate));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allPG;
        }

        public static ObservableList<PerishableGoods> PGListFromBinaryFile() {
            ObservableList<PerishableGoods> allPG = FXCollections.observableArrayList();
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE_PERISHABLE));
                PerishableGoods[] array = (PerishableGoods[]) fileReader.readObject();
                for (PerishableGoods nl : array) {
                    allPG.add(nl);
                }
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allPG;
        }

        public static boolean writeDataToPGBinaryFile(ObservableList<PerishableGoods> allPerishableList) {
            PerishableGoods[] array = new PerishableGoods[allPerishableList.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = allPerishableList.get(i);
            }
            try {
                ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_PERISHABLE));
                fileWriter.writeObject(array);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
            return true;
        }

        public static boolean NPGBinaryFileHasData() {
            File binaryFile = new File(BINARY_FILE_NON_PERISHABLE);
            return (binaryFile.exists() && binaryFile.length() >= 5L);
        }

        public static ObservableList<NonPerishable> NPGListFromTXTFile() {
            ObservableList<NonPerishable> allNPG = FXCollections.observableArrayList();
            String line;
            String[] parts;
            int itemNo;
            String category,productName, vendor, size;
            double price;

            try {
                Scanner fileScanner = new Scanner(new File(TXT_FILE_NON_PERISHABLE));
                fileScanner.nextLine();
                while (fileScanner.hasNextLine()) {
                    line = fileScanner.nextLine();
                    parts = line.split("\t");
                    itemNo = Integer.parseInt(parts[0]);
                    category = parts[1];
                    productName = parts[2];
                    vendor = parts[3];
                    price = Double.parseDouble(parts[4]);
                    size = parts[5];
                    allNPG.add(new NonPerishable(itemNo,category,productName,vendor,price, size));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allNPG;
        }
        public static ObservableList<NonPerishable> NPGListFromBinaryFile() {
            ObservableList<NonPerishable> allNPG = FXCollections.observableArrayList();
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE_NON_PERISHABLE));
                NonPerishable[] array = (NonPerishable[]) fileReader.readObject();
                for (NonPerishable nl : array) {
                    allNPG.add(nl);
                }
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allNPG;
        }

        public static boolean writeDataToNPGBinaryFile(ObservableList<NonPerishable> allPerishableList) {
            NonPerishable[] array = new NonPerishable[allPerishableList.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = allPerishableList.get(i);
            }
            try {
                ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_NON_PERISHABLE));
                fileWriter.writeObject(array);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
            return true;
        }

        public static boolean volunteerBinaryHasData(){
            File volunteerBinaryFile = new File(BINARY_FILE_VOLUNTEER);
            return (volunteerBinaryFile.exists() && volunteerBinaryFile.length() >= 5L);
        }

        public static ObservableList<Volunteer> populateListVolunteerBinaryFile() {

            ObservableList<Volunteer> volunteers = FXCollections.observableArrayList();
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE_VOLUNTEER));
                // read from binary file into an array
                Volunteer[] array = (Volunteer[]) fileReader.readObject();
                // loop through array and add each laureate to list
                for(Volunteer nl : array)
                    volunteers.add(nl);
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return volunteers;
        }

        public static ObservableList<Volunteer> populateFromVolunteerCSVFile(){

            ObservableList<Volunteer> allVolunteers = FXCollections.observableArrayList();

            String firstName;
            String lastName;
            int age;
            String phoneNumber;
            String email;
            String city;
            String reason;
            String animalType;
            String availability;
            String experience;
            String startDateORLocation;
            String endDateORDate;
            String housingORNickname;
            String transportationORwalkingString;
            boolean transportationORwalkingboolean;

            String line;
            String [] parts;

            try {
                Scanner fileScanner = new Scanner(new File(CSV_VOLUNTEER_FILE));
                // Skip the first line
                // Loop through the file
                fileScanner.nextLine(); // skip 1st line
                while(fileScanner.hasNextLine()){
                    // read one line from the CSV
                    line = fileScanner.nextLine();
                    parts = line.split(",");
                    firstName = parts[0];
                    lastName = parts[1];
                    age = Integer.parseInt(parts[2]);
                    phoneNumber = parts[3];
                    email = parts[4];
                    city = parts[5];
                    reason = parts[6];
                    animalType = parts[7];
                    availability = parts[8];
                    experience = parts[9];
                    startDateORLocation = parts[10];
                    endDateORDate = parts[11];
                    housingORNickname = parts[12];
                    transportationORwalkingString = parts[13];
                    if(transportationORwalkingString.equalsIgnoreCase("True"))
                        transportationORwalkingboolean = true;
                    else
                        transportationORwalkingboolean = false;
                    allVolunteers.add(
                            new InHouseVolunteer(firstName,lastName, age, phoneNumber, email, city, reason,
                                    animalType, availability, experience, startDateORLocation, endDateORDate, housingORNickname,
                                    transportationORwalkingboolean));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return allVolunteers;
        }

        public static boolean writeToVolunteerBinary(ObservableList<Volunteer> allVolunteers){

            Volunteer[] array = new Volunteer[allVolunteers.size()];
            // copy all the list data into the array
            for (int i = 0; i < array.length; i++) {
                array[i] = allVolunteers.get(i);
            }
            try {
                ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_VOLUNTEER));
                fileWriter.writeObject(array);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
            return true;
        }

    }