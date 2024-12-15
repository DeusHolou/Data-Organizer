package com.example.dataorganizerpt3;


public class DataEntry { // Class declaration

    private String name;
    private int value;

    // Constructor
    public DataEntry(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    // String representation of DataEntry
    @Override
    public String toString() {
        return "DataEntry{name='" + name + "', value=" + value + '}';
    }
} // End of class
