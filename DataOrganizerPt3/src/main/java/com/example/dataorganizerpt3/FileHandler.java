package com.example.dataorganizerpt3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Writes data to a file
    public static <T> void writeToFile(String filename, List<DataEntry<T>> dataEntries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (DataEntry<T> entry : dataEntries) {
                writer.write(entry.getData().toString());  // Writing the data as string
                writer.newLine();
            }
            System.out.println("Data successfully written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Reads data from a file
    public static List<DataEntry<?>> readFromFile(String filename) {
        List<DataEntry<?>> dataEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the data is a string, but can be extended for other types
                DataEntry<String> dataEntry = new DataEntry<>(line);
                dataEntries.add(dataEntry);
            }
            System.out.println("Data successfully read from " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return dataEntries;
    }
}
