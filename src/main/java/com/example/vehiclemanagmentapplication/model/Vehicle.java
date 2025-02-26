package com.example.vehiclemanagmentapplication.model;

import java.time.LocalDate;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private LocalDate purchaseDate;

    // Constructor
    public Vehicle(String make, String model, int year, LocalDate purchaseDate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.purchaseDate = purchaseDate;
    }

    // Getters & Setters
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " (Purchased: " + purchaseDate + ")";
    }
}
