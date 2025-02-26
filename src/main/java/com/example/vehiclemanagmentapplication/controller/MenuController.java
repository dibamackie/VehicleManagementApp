package com.example.vehiclemanagmentapplication.controller;

import com.example.vehiclemanagmentapplication.model.SummaryRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MenuController {


    // A static list
    private static final ObservableList<SummaryRecord> summaryRecords = FXCollections.observableArrayList();

    // A temporary record to hold data from each screen until the entry is complete
    // I made it static so by moving to the other fxml it still there
    private static SummaryRecord currentRecord = new SummaryRecord();


    // 1) STATIC LISTS FOR SUMMARY
    private static final List<String> vehicles = new ArrayList<>();
    private static final List<String> usageLogs = new ArrayList<>();
    private static final List<String> maintenanceRecords = new ArrayList<>();




    //vehicle.fxml fields
    @FXML
    private TextField vehicleBrandText;
    @FXML
    private TextField vehicleModelText;
    @FXML
    private TextField vehicleYearText;
    @FXML
    private ChoiceBox<String> vehicleTypeChoice;


    //usage.fxml fields
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField kilometersDrivenText;


    // Records.fxml fields
    @FXML
    private DatePicker dateText;
    @FXML
    private TextField costText;
    @FXML
    private TextArea descText;


    // summary.fxml field
    @FXML
    private TextArea summaryTextArea;


    @FXML
    public void initialize() {
        // Vehicle screen initialization
        if (vehicleTypeChoice != null) {
            vehicleTypeChoice.getItems().addAll(
                    "Hatchback",
                    "Sedan",
                    "SUV",
                    "MUV",
                    "Coupe",
                    "Convertible",
                    "Pickup Truck"
            );
        }

        // initialization fo usage
        if (startDatePicker != null && endDatePicker != null) {
            startDatePicker.setValue(LocalDate.now());
            endDatePicker.setValue(LocalDate.now());
        }

        //initialization for maintenance
        if (dateText != null) {
            dateText.setValue(LocalDate.now());
        }

        //initialization for summary
        if (summaryTextArea != null) {
            // Build summary string from summaryRecords list
            StringBuilder sb = new StringBuilder();
            for (SummaryRecord record : summaryRecords) {
                sb.append(record.toString()).append("\n-----------------\n");
            }
            summaryTextArea.setText(sb.toString());
        }
    }



    // Menu.fxml methods
    @FXML
    private void manageVehicles(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/vehiclemanagmentapplication/vehicle.fxml")
        );
        switchScene(event, root);
    }

    @FXML
    private void manageUsageLogs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/vehiclemanagmentapplication/usage.fxml")
        );
        switchScene(event, root);
    }

    @FXML
    private void manageMaintenance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/vehiclemanagmentapplication/Records.fxml")
        );
        switchScene(event, root);
    }

    @FXML
    private void viewSummary(ActionEvent event) throws IOException {
        // Load summary.fxml
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/vehiclemanagmentapplication/summary.fxml")
        );
        switchScene(event, root);
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        Parent root = null;

        // Check if we are on the Vehicle screen.
        // (Assume vehicle.fxml defines vehicleBrandText.)
        if (vehicleBrandText != null) {
            // Next goes to Usage screen
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/usage.fxml"));
        }
        // Otherwise, if we are on the Usage screen.
        else if (startDatePicker != null && endDatePicker != null && kilometersDrivenText != null) {
            // Next goes to Records (maintenance) screen.
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/Records.fxml"));
        }
        // Otherwise, if we are on the Records screen.
        else if (dateText != null && costText != null && descText != null) {
            // Next goes to Summary screen.
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/summary.fxml"));
        }
        // Otherwise, if we are on the Summary screen.
        else if (summaryTextArea != null) {
            // Next might go back to the main menu or start over.
            // For this example, we'll return to the menu.
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/menu.fxml"));
        }

        if (root != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            System.out.println("Unable to determine current screen for Next navigation.");
        }
    }


    @FXML
    private void quit(ActionEvent event) {
        Platform.exit();
    }


    // save, next and menu button
    @FXML
    private void save(ActionEvent event) throws IOException {
        Parent root = null;

        // 1) VEHICLE
        if (vehicleBrandText != null && vehicleModelText != null
                && vehicleYearText != null && vehicleTypeChoice != null) {
            // Save vehicle data into currentRecord
            currentRecord.setBrand(vehicleBrandText.getText());
            currentRecord.setModel(vehicleModelText.getText());
            currentRecord.setYear(vehicleYearText.getText());
            currentRecord.setType(vehicleTypeChoice.getValue());

            // gp to usage
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/usage.fxml"));
        }
        // 2) USAGE
        else if (startDatePicker != null && endDatePicker != null && kilometersDrivenText != null) {
            // Save usage data into currentRecord
            currentRecord.setStartDate(startDatePicker.getValue());
            currentRecord.setEndDate(endDatePicker.getValue());
            currentRecord.setKilometers(kilometersDrivenText.getText());

            //go to records
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/Records.fxml"));
        }

        // 3) MAINTENANCE SCREEN
        else if (dateText != null && costText != null && descText != null) {
            currentRecord.setMaintenanceDate(dateText.getValue());
            currentRecord.setCost(costText.getText());
            currentRecord.setDescription(descText.getText());

            // after all add it all to summaryRecords
            summaryRecords.add(currentRecord);

            // Reset currentRecord for the next entry
            currentRecord = new SummaryRecord();

            // go to summary
            root = FXMLLoader.load(getClass().getResource("/com/example/vehiclemanagmentapplication/summary.fxml"));
        }
        else {
            System.out.println("No recognized fields for saving.");
            return;
        }

        if (root != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        // Return to main menu
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/vehiclemanagmentapplication/menu.fxml")
        );
        switchScene(event, root);
    }


    // Utility method to switch scenes
    private void switchScene(ActionEvent event, Parent root) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
