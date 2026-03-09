package org.codedifferently;

// Customer models a rewards member at Triple C's Coffee Shop.
// It tracks personal info, punch card progress, and their spending tier.
//
// TIER SYSTEM (based on transaction total):
//   Tier 1 (T1) — spend over $10  → 5% discount on the order
//   Tier 2 (T2) — spend over $20  → 1 free item added
//   Tier 3 (T3) — spend over $50  → 2 free items added
//
// Tiers are evaluated once per transaction in Main after the order is complete.
public class Customer {

    private String custName;
    private String custEmail;

    // numberOfDrinks acts as a digital punch card.
    // Every drink purchased increments this; reaching 5 unlocks a free drink.
    private int numberOfDrinks;

    // Tier constants — stored here so Main and Receipt can reference them cleanly
    public static final int TIER_NONE = 0;
    public static final int TIER_1    = 1;   // spend > $10 → 5% off
    public static final int TIER_2    = 2;   // spend > $20 → 1 free item
    public static final int TIER_3    = 3;   // spend > $50 → 2 free items

    // Default constructor: used when signing up a new customer mid-transaction.
    // Fields are populated afterward via setters once the user enters their info.
    public Customer() {
        this.custName = "";
        this.custEmail = "";
        this.numberOfDrinks = 0;
    }

    // Overloaded constructor for convenience when name and email are known upfront
    public Customer(String custName, String custEmail) {
        this.custName = custName;
        this.custEmail = custEmail;
        this.numberOfDrinks = 0;
    }

    // -------- GETTERS --------

    public String getCustName() {
        return custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }

    // -------- SETTERS --------

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public void setNumberOfDrinks(int numberOfDrinks) {
        this.numberOfDrinks = numberOfDrinks;
    }

    // -------- REWARDS PUNCH CARD --------

    // Increments punch card by 1 each time a drink is purchased
    public void addDrink() {
        this.numberOfDrinks++;
    }

    // Returns true when the customer has hit the 5-drink threshold for a free drink
    public boolean rewardsEligible() {
        return numberOfDrinks >= 5;
    }

    // Resets punch card to 0 after a free drink is redeemed
    public void drinksReset() {
        this.numberOfDrinks = 0;
    }

    // -------- TIER LOGIC --------
    // getTier evaluates the transaction total and returns the customer's spending tier.
    // Checking > 50 first ensures we return the highest applicable tier correctly.
    // This method is called once per transaction after the order loop completes.
    public static int getTier(double total) {
        if (total > 50) return TIER_3;
        if (total > 20) return TIER_2;
        if (total > 10) return TIER_1;
        return TIER_NONE;
    }

    // Returns a human-readable description of the tier benefit for the receipt
    public static String getTierDescription(int tier) {
        switch (tier) {
            case TIER_1: return "Tier 1 - 5% discount applied!";
            case TIER_2: return "Tier 2 - 1 free item earned!";
            case TIER_3: return "Tier 3 - 2 free items earned!";
            default:     return "";
        }
    }
}