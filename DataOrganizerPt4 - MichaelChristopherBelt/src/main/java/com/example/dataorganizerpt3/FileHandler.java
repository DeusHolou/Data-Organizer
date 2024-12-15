package com.example.dataorganizerpt3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Save data to file
    public static void saveDataToFile(List<DataCategory> categories, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(categories);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from file
    public static List<DataCategory> loadDataFromFile(String filename) {
        List<DataCategory> categories = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            categories = (List<DataCategory>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
