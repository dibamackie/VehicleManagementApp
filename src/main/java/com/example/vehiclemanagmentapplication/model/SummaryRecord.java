package com.example.vehiclemanagmentapplication.model;

import java.time.LocalDate;

public class SummaryRecord {
    private String brand;
    private String model;
    private String year;
    private String type;

    private LocalDate startDate;
    private LocalDate endDate;
    private String kilometers;

    private LocalDate maintenanceDate;
    private String cost;
    private String description;

    // No-arg constructor
    public SummaryRecord() {}

    // Getters and Setters
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getKilometers() {
        return kilometers;
    }
    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }
    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "=== Vehicles ===\n" +
                "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Type: " + type + "\n" +
                "=== Usage Logs ===\n" +
                "Start Date: " + startDate + ", End Date: " + endDate + ", Kilometers: " + kilometers + "\n" +
                "=== Maintenance Records ===\n" +
                "Date: " + maintenanceDate + ", Cost: " + cost + ", Description: " + description + "\n";
    }
}