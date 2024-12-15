package com.example.dataorganizerpt3;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue<T> { // Class declaration starts here

    private Queue<T> queue; // A field to hold the queue data

    // Constructor to initialize the queue
    public DataQueue() {
        queue = new LinkedList<>();
    }

    // Add an item to the queue
    public void enqueue(T item) {
        queue.offer(item);
    }

    // Remove and return the front item of the queue
    public T dequeue() {
        return queue.poll();
    }

    // Peek at the front item without removing it
    public T peek() {
        return queue.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }

    // Convert the queue to a string representation
    @Override
    public String toString() {
        return queue.toString();
    }
} // End of class
