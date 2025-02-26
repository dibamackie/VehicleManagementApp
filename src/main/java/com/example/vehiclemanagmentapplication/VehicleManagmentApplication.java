package com.example.vehiclemanagmentapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleManagmentApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load your FXML file (e.g., menu.fxml) from resources.
        // Make sure menu.fxml is in src/main/resources/com/example/vehiclemanagmentapplication/
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/vehiclemanagmentapplication/menu.fxml")
        );

        Parent root = loader.load();

        primaryStage.setTitle("Vehicle Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
