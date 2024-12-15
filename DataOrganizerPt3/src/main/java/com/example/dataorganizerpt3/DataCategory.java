package com.example.dataorganizerpt3;

import java.util.ArrayList;
import java.util.List;

public class DataCategory {
    private String title;
    private List<DataEntry<?>> entries;

    public DataCategory(String title) {
        this.title = title;
        this.entries = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<DataEntry<?>> getEntries() {
        return entries;
    }

    // Add a data entry under the category
    public void addEntry(String data) {
        DataEntry<String> entry = new DataEntry<>(data);
        entries.add(entry);
    }
}
