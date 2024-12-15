package com.example.dataorganizerpt3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;


import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class MainApp extends Application {

    // Declare the CustomLinkedList and FileHandler for file operations
    private CustomLinkedList<DataEntry<String>> dataEntries;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the linked list
        dataEntries = new CustomLinkedList<>();

        // Create UI elements
        VBox vbox = new VBox(10);
        Label label = new Label("Data Organizer Application");
        TextArea displayArea = new TextArea();
        TextField inputField = new TextField();
        Button addButton = new Button("Add Data");
        Button loadButton = new Button("Load Data from File");
        Button saveButton = new Button("Save Data to File");

        // Set up actions for buttons
        addButton.setOnAction(e -> {
            String inputData = inputField.getText();
            if (!inputData.isEmpty()) {
                DataEntry<String> dataEntry = new DataEntry<>(inputData);
                dataEntries.add(dataEntry);
                inputField.clear();
                displayData(displayArea);
            }
        });

        loadButton.setOnAction(e -> {
            List<DataEntry<?>> loadedData = FileHandler.readFromFile("data.txt");
            dataEntries = new CustomLinkedList<>();
            for (DataEntry<?> entry : loadedData) {
                dataEntries.add((DataEntry<String>) entry);
            }
            displayData(displayArea);
        });

        saveButton.setOnAction(e -> {
            FileHandler.writeToFile("data.txt", dataEntries.toList());
        });

        // Set up the layout
        vbox.getChildren().addAll(label, inputField, addButton, loadButton, saveButton, displayArea);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Data Organizer App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayData(TextArea displayArea) {
        StringBuilder displayText = new StringBuilder();
        List<DataEntry<String>> list = dataEntries.toList();
        for (DataEntry<String> entry : list) {
            displayText.append(entry.getData()).append("\n");
        }
        displayArea.setText(displayText.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
