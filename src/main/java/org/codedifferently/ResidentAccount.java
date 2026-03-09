package org.codedifferently;

// Represents a resident's account for billing and payments
public class ResidentAccount {

    private String residentName;
    private String apartmentNumber;
    private double balanceDue;

    // Constructor
    public ResidentAccount(String residentName, String apartmentNumber, double balanceDue) {
        this.residentName = residentName;
        this.apartmentNumber = apartmentNumber;
        this.balanceDue = balanceDue;
    }

    // Getter methods
    public String getResidentName() {
        return residentName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    // Adds a charge to the resident's balance
    public void addCharge(double amount) {
        if (amount > 0) {
            balanceDue += amount;
        }
    }

    // Allows resident to make a payment
    public void makePayment(double amount) {
        if (amount > 0 && amount <= balanceDue) {
            balanceDue -= amount;
        } else {
            System.out.println("INVALID PAYMENT AMOUNT");
        }
    }

    // Display account information
    @Override
    public String toString() {
        return "Resident: " + residentName +
                " | Apt: " + apartmentNumber +
                " | Balance Due: $" + String.format("%.2f", balanceDue);
    }
}