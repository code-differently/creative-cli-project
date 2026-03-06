package org.codedifferently;

public class ResidentAccount {


        private String residentName;
        private int apartmentNumber;
        private double balanceDue;

        public ResidentAccount(String residentName, int apartmentNumber, double balanceDue) {
            this.residentName = residentName;
            this.apartmentNumber = apartmentNumber;
            this.balanceDue = balanceDue;
        }

        public String getResidentName() {
            return residentName;
        }

        public int getApartmentNumber() {
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
            }
        }

        @Override
        public String toString() {
            return "Resident: " + residentName +
                    " | Apt: " + apartmentNumber +
                    " | Balance Due: $" + balanceDue;
        }
    }

