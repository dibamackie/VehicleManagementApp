//package com.example.vehiclemanagmentapplication.view;
//
//import com.example.vehiclemanagmentapplication.controller.MainController;
//import com.example.vehiclemanagmentapplication.model.Vehicle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import java.time.LocalDate;
//
//public class MainView {
//    private Stage stage;
//    private MainController mainController;
//    private ObservableList<Vehicle> vehicleList;
//    private ListView<Vehicle> listView;
//
//    // Two-argument constructor: Stage and MainController
//    public MainView(Stage stage, MainController mainController) {
//        this.stage = stage;
//        this.mainController = mainController;
//        this.vehicleList = FXCollections.observableArrayList();
//    }
//
//    public void show() {
//        stage.setTitle("Vehicle Management");
//
//        // Input Fields
//        TextField makeField = new TextField();
//        makeField.setPromptText("Vehicle Make");
//
//        TextField modelField = new TextField();
//        modelField.setPromptText("Vehicle Model");
//
//        TextField yearField = new TextField();
//        yearField.setPromptText("Year");
//
//        DatePicker purchaseDate = new DatePicker();
//
//        // Buttons
//        Button saveButton = new Button("Save");
//        Button clearButton = new Button("Clear");
//
//        // List View
//        listView = new ListView<>(vehicleList);
//
//        // Button Actions
//        saveButton.setOnAction(e -> {
//            try {
//                String make = makeField.getText();
//                String model = modelField.getText();
//                int year = Integer.parseInt(yearField.getText());
//                LocalDate date = purchaseDate.getValue();
//
//                if (make.isEmpty() || model.isEmpty() || date == null) {
//                    showAlert("Error", "All fields must be filled!");
//                    return;
//                }
//
//                Vehicle vehicle = new Vehicle(make, model, year, date);
//                vehicleList.add(vehicle);
//                // Optionally, notify the controller if needed:
//                // mainController.addVehicle(vehicle);
//
//                // Clear fields
//                makeField.clear();
//                modelField.clear();
//                yearField.clear();
//                purchaseDate.setValue(null);
//            } catch (NumberFormatException ex) {
//                showAlert("Error", "Year must be a number!");
//            }
//        });
//
//        clearButton.setOnAction(e -> {
//            makeField.clear();
//            modelField.clear();
//            yearField.clear();
//            purchaseDate.setValue(null);
//        });
//
//        // Layout
//        HBox inputRow1 = new HBox(10, makeField, modelField);
//        HBox inputRow2 = new HBox(10, yearField, purchaseDate);
//        HBox buttonRow = new HBox(10, saveButton, clearButton);
//        VBox layout = new VBox(10, inputRow1, inputRow2, buttonRow, listView);
//        layout.setPadding(new Insets(10));
//
//        stage.setScene(new Scene(layout, 400, 300));
//        stage.show();
//    }
//
//    private void showAlert(String title, String message) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}
