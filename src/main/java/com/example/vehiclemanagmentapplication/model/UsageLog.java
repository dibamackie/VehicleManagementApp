package com.example.vehiclemanagmentapplication.model;

import java.time.LocalDate;

public class UsageLog {
    private Vehicle vehicle;
    private LocalDate tripDate;
    private double distance; // in kilometers
    private String purpose;  // Example: Work, Personal, Business Trip

    // Constructor
    public UsageLog(Vehicle vehicle, LocalDate tripDate, double distance, String purpose) {
        this.vehicle = vehicle;
        this.tripDate = tripDate;
        this.distance = distance;
        this.purpose = purpose;
    }

    // Getters & Setters
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }
    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Usage Log - " + vehicle + " on " + tripDate + ": " + distance + " km (" + purpose + ")";
    }
}
