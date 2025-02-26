//package com.example.vehiclemanagmentapplication.view;
//
//import com.example.vehiclemanagmentapplication.model.Vehicle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class SummaryView {
//    private Stage stage;
//    private ObservableList<Vehicle> vehicleList;
//
//    public SummaryView(Stage stage, ObservableList<Vehicle> vehicles) {
//        this.stage = stage;
//        this.vehicleList = vehicles;
//    }
//
//    public void show() {
//        stage.setTitle("Vehicle Summary");
//
//        // List View to Display Vehicles
//        ListView<Vehicle> summaryListView = new ListView<>(vehicleList);
//
//        // Layout
//        VBox layout = new VBox(10, summaryListView);
//        layout.setPadding(new Insets(10));
//
//        stage.setScene(new Scene(layout, 400, 300));
//        stage.show();
//    }
//}
//
