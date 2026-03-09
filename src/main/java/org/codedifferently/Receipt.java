package org.codedifferently;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Receipt builds and prints a full formatted receipt for a single transaction.
// It is constructed after an order is complete and holds all line items,
// discounts, tier info, and the final total.
//
// Separating receipt logic into its own class keeps Main clean and makes it easy
// to change receipt formatting without touching order or rewards logic.
public class Receipt {

    // Each item added to the order is stored as a String line (e.g. "Iced Latte  $4.25")
    // ArrayList is used because the number of items per order is unknown ahead of time.
    private ArrayList<String> lineItems = new ArrayList<>();

    private double subtotal    = 0.0;
    private double discount    = 0.0;   // dollar amount saved (T1 = 5%)
    private double finalTotal  = 0.0;
    private int    freeItems   = 0;     // number of free items granted (T2=1, T3=2)
    private int    tier;
    private String cashierName;
    private String customerName;

    // Constructor ties the receipt to the cashier and customer from the start
    public Receipt(String cashierName, String customerName, int tier) {
        this.cashierName  = cashierName;
        this.customerName = customerName;
        this.tier         = tier;
    }

    // Adds a paid line item to the receipt and accumulates the subtotal.
    // Called once per item during the order loop in Main.
    public void addItem(String itemName, double cost) {
        lineItems.add(String.format("  %-33s $%5.2f", itemName, cost));
        subtotal += cost;
    }

    // Adds a free item line (marked FREE) — no cost added to subtotal.
    // Used for punch card rewards, T2/T3 tier free items.
    public void addFreeItem(String itemName) {
        lineItems.add(String.format("  %-33s   FREE", itemName));
        freeItems++;
    }

    // calculateTotals applies the tier discount (if T1) and sets the final total.
    // Called once after all items are added, before printing.
    public void calculateTotals() {
        if (tier == Customer.TIER_1) {
            // T1: 5% off the subtotal
            discount   = subtotal * 0.05;
            finalTotal = subtotal - discount;
        } else {
            discount   = 0.0;
            finalTotal = subtotal;
        }
    }

    // printReceipt outputs a fully formatted Starbucks-style receipt to the console.
    // It includes the store header, cashier, timestamp, all items, discounts, and tier status.
    public void printReceipt() {
        // Format timestamp as readable date/time
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM/dd/yyyy  hh:mm a"));

        System.out.println("\n  ╔══════════════════════════════════════════════╗");
        System.out.println("  ║           MONEY BUCKS COFFEE SHOP            ║");
        System.out.println("  ║         1234 Main St, Your City, ST          ║");
        System.out.println("  ║              (555) 867-5309                  ║");
        System.out.println("  ╚══════════════════════════════════════════════╝");
        System.out.printf( "  Date: %-38s%n", timestamp);
        System.out.printf( "  Cashier: %-35s%n", cashierName);
        System.out.printf( "  Customer: %-34s%n",
                customerName.isEmpty() ? "Guest" : customerName);
        System.out.println("──────────────────────────────────────────────");
        System.out.println("  ITEMS:");

        // Print every line item (paid and free) stored during the order loop
        for (String line : lineItems) {
            System.out.println(line);
        }

        System.out.println("──────────────────────────────────────────────");
        System.out.printf("  Subtotal:                         $%5.2f%n", subtotal);

        // Only show discount line if a T1 discount was applied
        if (discount > 0) {
            System.out.printf("  Tier 1 Discount (5%% off):        -$%5.2f%n", discount);
        }

        // Tier badge on receipt
        if (tier != Customer.TIER_NONE) {
            System.out.printf("  %-44s%n", "  ★ " + Customer.getTierDescription(tier));
        }

        System.out.println("──────────────────────────────────────────────");
        System.out.printf("  TOTAL:                            $%5.2f%n", finalTotal);
        System.out.println("══════════════════════════════════════════════");
        System.out.println("  Thank you for visiting  Money Bucks!");
        System.out.println("  Enjoy your order ☕");
        System.out.println("══════════════════════════════════════════════\n");
    }

    // -------- GETTERS --------
    // Main uses these to pass final amounts to the Sales tracker

    public double getFinalTotal() {
        return finalTotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getFreeItemsGranted() {
        return freeItems;
    }
}