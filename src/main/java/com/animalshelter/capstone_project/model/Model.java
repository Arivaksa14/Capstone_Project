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
    }