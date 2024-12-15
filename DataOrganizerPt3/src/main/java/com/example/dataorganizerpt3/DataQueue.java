package com.example.dataorganizerpt3;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue<T> {

    private Queue<T> queue;

    public DataQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T data) {
        queue.add(data);
    }

    public T dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
