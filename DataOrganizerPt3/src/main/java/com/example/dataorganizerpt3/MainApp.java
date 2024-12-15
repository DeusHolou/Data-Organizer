package com.example.dataorganizerpt3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private DataManager dataManager = new DataManager();
    private static final String FILE_NAME = "data.txt";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Data Organizer");

        // UI Components
        ListView<String> listView = new ListView<>();
        TextField inputField = new TextField();
        Button addButton = new Button("Add");
        Button saveButton = new Button("Save");
        Button loadButton = new Button("Load");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button clearButton = new Button("Clear");
        Button sortButton = new Button("Sort");

        // Populate ListView with data
        updateListView(listView);

        // Event Handlers
        addButton.setOnAction(event -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                dataManager.addData(input);
                updateListView(listView);
                inputField.clear();
            }
        });

        saveButton.setOnAction(event -> {
            dataManager.saveDataToFile(FILE_NAME);
            showAlert(Alert.AlertType.INFORMATION, "Save Successful", "Data has been saved to " + FILE_NAME);
        });

        loadButton.setOnAction(event -> {
            dataManager.loadDataFromFile(FILE_NAME);
            updateListView(listView);
            showAlert(Alert.AlertType.INFORMATION, "Load Successful", "Data has been loaded from " + FILE_NAME);
        });

        editButton.setOnAction(event -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            String input = inputField.getText();
            if (selected != null && !input.isEmpty()) {
                boolean success = dataManager.editData(selected, input);
                if (success) {
                    updateListView(listView);
                    showAlert(Alert.AlertType.INFORMATION, "Edit Successful", "Data has been updated.");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Edit Failed", "Could not find the item to edit.");
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Edit Failed", "Please select an item and provide new text.");
            }
        });

        deleteButton.setOnAction(event -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                boolean success = dataManager.deleteData(selected);
                if (success) {
                    updateListView(listView);
                    showAlert(Alert.AlertType.INFORMATION, "Delete Successful", "Item has been deleted.");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Delete Failed", "Could not delete the item.");
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Delete Failed", "Please select an item to delete.");
            }
        });

        clearButton.setOnAction(event -> {
            dataManager.clearData();
            updateListView(listView);
            showAlert(Alert.AlertType.INFORMATION, "Clear Successful", "All data has been cleared.");
        });

        sortButton.setOnAction(event -> {
            dataManager.sortData(); // Sorts the data alphabetically
            updateListView(listView);
            showAlert(Alert.AlertType.INFORMATION, "Sort Successful", "Data has been sorted alphabetically.");
        });

        // Layout
        VBox layout = new VBox(10, listView, inputField, addButton, saveButton, loadButton, editButton, deleteButton, clearButton, sortButton);
        Scene scene = new Scene(layout, 400, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateListView(ListView<String> listView) {
        listView.getItems().setAll(dataManager.getDataStrings());
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
