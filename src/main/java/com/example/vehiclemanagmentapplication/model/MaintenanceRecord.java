package com.example.vehiclemanagmentapplication.model;

import java.time.LocalDate;

public class MaintenanceRecord {
    private LocalDate serviceDate;
    private String description;
    private double cost;
    private Vehicle vehicle;

    // Constructor
    public MaintenanceRecord(Vehicle vehicle, LocalDate serviceDate, String description, double cost) {
        this.vehicle = vehicle;
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }
    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Maintenance for " + vehicle + " on " + serviceDate + ": " + description + " ($" + cost + ")";
    }
}
