package com.example.dataorganizerpt3;

import java.util.LinkedList;

public class CustomHashTable<K, V> {

    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        table[index].removeIf(entry -> entry.key.equals(key));
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }
}
