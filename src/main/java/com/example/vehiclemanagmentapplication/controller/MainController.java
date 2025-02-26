//package com.example.vehiclemanagmentapplication.controller;
//
//import com.example.vehiclemanagmentapplication.model.Vehicle;
//import com.example.vehiclemanagmentapplication.view.MainView;
//import com.example.vehiclemanagmentapplication.view.SummaryView;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.stage.Stage;
//
//public class MainController {
//    private ObservableList<Vehicle> vehicleList;
//
//    public MainController() {
//        vehicleList = FXCollections.observableArrayList();
//    }
//
//    public void start(Stage stage) {
//        MainView mainView = new MainView(stage, this);
//        mainView.show();
//    }
//
//    public void addVehicle(Vehicle vehicle) {
//        vehicleList.add(vehicle);
//    }
//
//    public void openSummaryView(Stage stage) {
//        SummaryView summaryView = new SummaryView(stage, vehicleList);
//        summaryView.show();
//    }
//
//    public ObservableList<Vehicle> getVehicleList() {
//        return vehicleList;
//    }
//}
