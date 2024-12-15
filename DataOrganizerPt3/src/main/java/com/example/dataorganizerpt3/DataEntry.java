package com.example.dataorganizerpt3;

public class DataEntry<T> {
    private T data;

    public DataEntry(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
