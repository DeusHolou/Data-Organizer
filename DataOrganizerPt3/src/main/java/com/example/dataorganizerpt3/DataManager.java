package com.example.dataorganizerpt3;

import java.util.ArrayList;

public class DataManager<T> {

    private ArrayList<T> data;

    public DataManager() {
        this.data = new ArrayList<>();
    }

    public void addData(T dataItem) {
        data.add(dataItem);
    }

    // Efficient sorting algorithm: QuickSort
    public void sortData() {
        quickSort(data, 0, data.size() - 1);
    }

    // QuickSort algorithm with efficiency comments
    private void quickSort(ArrayList<T> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);  // Recursively sort left part
            quickSort(data, pi + 1, high); // Recursively sort right part
        }
    }

    private int partition(ArrayList<T> data, int low, int high) {
        T pivot = data.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (((Comparable<T>) data.get(j)).compareTo(pivot) <= 0) {
                i++;
                T temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }

        T temp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, temp);
        return i + 1;
    }

    public ArrayList<T> getData() {
        return data;
    }
}
