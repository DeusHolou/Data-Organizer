package com.example.dataorganizerpt3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private final List<String> dataList;

    public DataManager() {
        this.dataList = new ArrayList<>();
    }

    // Add new data
    public void addData(String data) {
        dataList.add(data);
    }

    // Edit existing data
    public boolean editData(String oldData, String newData) {
        int index = dataList.indexOf(oldData);
        if (index != -1) {
            dataList.set(index, newData);
            return true;
        }
        return false;
    }

    // Delete data
    public boolean deleteData(String data) {
        return dataList.remove(data);
    }

    // Clear all data
    public void clearData() {
        dataList.clear();
    }

    // Sort data alphabetically
    public void sortData() {
        dataList.sort(String::compareToIgnoreCase); // Case-insensitive alphabetical sort
    }

    // Save data to file
    public void saveDataToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String data : dataList) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from file
    public void loadDataFromFile(String fileName) {
        dataList.clear(); // Clear current data before loading new data
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get data as a list of strings
    public List<String> getDataStrings() {
        return new ArrayList<>(dataList); // Return a copy to prevent external modification
    }
}
