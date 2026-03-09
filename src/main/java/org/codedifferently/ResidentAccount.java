package org.codedifferently;

public class ResidentAccount {
    private String residentName;
    private String apartmentNumber;
    private double balanceDue;

    public ResidentAccount(String residentName, String apartmentNumber, double balanceDue) {
        this.residentName = residentName;
        this.apartmentNumber = apartmentNumber;
        this.balanceDue = balanceDue;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public void addCharge(double amount) {
        if (amount > 0) {
            balanceDue += amount;
        }
    }

    public void makePayment(double amount) {
        if (amount > 0 && amount <= balanceDue) {
            balanceDue -= amount;
        } else {
            System.out.println("INVALID PAYMENT AMOUNT");
        }
    }

    @Override
    public String toString() {
        return "Resident: " + residentName +
                " | Apt: " + apartmentNumber +
                " | Balance Due: $" + String.format("%.2f", balanceDue);
    }
}
