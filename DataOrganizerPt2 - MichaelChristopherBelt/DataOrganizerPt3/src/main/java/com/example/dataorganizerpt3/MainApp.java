package com.example.dataorganizerpt3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application { // Class declaration

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox();
        Button addButton = new Button("Add Entry");
        Button sortButton = new Button("Sort Entries");

        layout.getChildren().addAll(addButton, sortButton);

        primaryStage.setTitle("Data Organizer");
        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} // End of class
