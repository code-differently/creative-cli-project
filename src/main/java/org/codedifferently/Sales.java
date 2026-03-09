package org.codedifferently;

import java.util.ArrayList;

// Sales tracks all business metrics for the entire day's operation.
// A single Sales instance is created in Main and shared across all customer transactions.
//
// NEW: cashierNames is an ArrayList that stores every cashier who clocked in during the day.
// ArrayList is used here instead of an array because we don't know ahead of time
// how many cashiers will work — the list grows dynamically as names are added.
public class Sales {

    private int drinksSold = 0;
    private double totalRevenue = 0.0;
    private int totalCustomers = 0;

    // ArrayList chosen because the number of cashiers per day is dynamic and unknown upfront.
    // Each cashier's name is stored as a String when they start their shift.
    private ArrayList<String> cashierNames = new ArrayList<>();

    // -------- CASHIER METHODS --------

    // Adds a cashier name to the list when they clock in for the day.
    // Using add() on ArrayList appends to the end — no index management needed.
    public void addCashier(String name) {
        cashierNames.add(name);
    }

    // Returns the full list of cashiers for the daily summary printout
    public ArrayList<String> getCashierNames() {
        return cashierNames;
    }

    // -------- TRANSACTION METHODS --------

    // Called once per item added to an order
    public void soldDrink() {
        drinksSold++;
    }

    // Called once at the start of each customer's transaction
    public void newCustomer() {
        totalCustomers++;
    }

    // Adds the price of a paid item to the daily revenue total.
    // Free items and discounted amounts are handled in Main before calling this.
    public void addCost(double amount) {
        totalRevenue += amount;
    }

    // -------- GETTERS --------

    public int getDrinksSold() {
        return drinksSold;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}