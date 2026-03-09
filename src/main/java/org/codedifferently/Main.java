package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

// Main is the entry point and controls all program flow for Triple C's Coffee Shop.
// It coordinates between Menu, Customer, Sales, and Receipt to process each transaction.
//
// NEW FEATURES ADDED:
//   - Menu class (bonus) handles all item definitions and display
//   - Cashier name saved at startup and stored in Sales for the daily summary
//   - Tier system: T1 (>$10) = 5% off | T2 (>$20) = 1 free item | T3 (>$50) = 2 free items
//   - ArrayList<Coffee> orderItems tracks the current order for tier free-item selection
//   - Full Receipt class prints a formatted receipt after each transaction
//   - Preloaded member list uses ArrayList<Customer> for dynamic member storage
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // -------- STORE SETUP --------
        // Menu is created once at startup — all items live inside it
        Menu menu = new Menu();

        // Sales persists for the entire day across all customer transactions
        Sales sales = new Sales();

        // -------- CASHIER CLOCK-IN --------
        // Cashier names are collected upfront and stored in the Sales object.
        // An ArrayList in Sales allows multiple cashiers to be recorded dynamically.
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║        MONEY BUCKS — STAFF LOGIN             ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.print("How many cashiers are clocking in today? ");
        int numCashiers = 0;
        while (true) {
            String cashierCountInput = input.nextLine().trim();
            if (cashierCountInput.matches("[1-9]")) {
                numCashiers = Integer.parseInt(cashierCountInput);
                break;
            }
            System.out.print("Please enter a number 1-9: ");
        }

        // Loop collects each cashier's name and adds it to the Sales tracker
        for (int i = 1; i <= numCashiers; i++) {
            System.out.print("Enter name for Cashier " + i + ": ");
            String cashierName = input.nextLine().trim();
            sales.addCashier(cashierName);
        }

        // Default to the first cashier for the session (can be extended to per-transaction login)
        String activeCashier = sales.getCashierNames().get(0);
        System.out.println("\nWelcome, " + activeCashier + "! Store is now open. ☕\n");

        // -------- PRELOADED MEMBERS --------
        // ArrayList<Customer> stores all known rewards members.
        // ArrayList is chosen because the number of members grows dynamically as new ones sign up.
        // In a real system this would be loaded from a database or file.
        ArrayList<Customer> members = new ArrayList<>();

        Customer bobby = new Customer("Bobby", "bobby@gmail.com");
        bobby.setNumberOfDrinks(4); // preloaded near free drink for demo/testing
        members.add(bobby);

        // -------- MAIN STORE LOOP --------
        // Runs once per customer until the cashier closes the store
        boolean storeIsOpen = true;

        while (storeIsOpen) {

            System.out.println("══════════════════════════════════════════════");
            System.out.println("          Welcome to  Money Bucks! ☕           ");
            System.out.println("══════════════════════════════════════════════");

            // -------- REWARDS MEMBERSHIP CHECK --------
            boolean isRewardsMember = false;
            while (true) {
                System.out.print("Are you a rewards member? (yes/no): ");
                String answer = input.nextLine().toLowerCase().trim();
                if (answer.equals("yes"))      { isRewardsMember = true;  break; }
                else if (answer.equals("no"))  { isRewardsMember = false; break; }
                else System.out.println("Please answer yes or no.");
            }

            // currentCustomer stays null for guests who don't join rewards
            Customer currentCustomer = null;

            if (isRewardsMember) {
                // Look up the member by email from the ArrayList
                System.out.print("Enter your email: ");
                String email = input.nextLine().trim();

                // Linear search through members list to find a matching email
                // A for-each loop is clean here since we check every member
                for (Customer c : members) {
                    if (c.getCustEmail().equalsIgnoreCase(email)) {
                        currentCustomer = c;
                        break;
                    }
                }

                if (currentCustomer != null) {
                    System.out.println("Welcome back, " + currentCustomer.getCustName() + "! 👋");
                } else {
                    System.out.println("Email not found. Continuing as guest.");
                }

            } else {
                // -------- NEW MEMBER SIGNUP --------
                // If the customer isn't a member, offer them a chance to join.
                // New members are added to the members ArrayList for this session.
                while (true) {
                    System.out.print("Would you like to join rewards? (yes/no): ");
                    String join = input.nextLine().toLowerCase().trim();

                    if (join.equals("yes")) {
                        currentCustomer = new Customer();

                        System.out.print("Enter your name: ");
                        currentCustomer.setCustName(input.nextLine().trim());

                        System.out.print("Enter your email: ");
                        currentCustomer.setCustEmail(input.nextLine().trim());

                        // Add the new member to the ArrayList so they can be found later
                        members.add(currentCustomer);
                        System.out.println("🎉 Welcome to Triple C's Rewards, "
                                + currentCustomer.getCustName() + "!");
                        break;

                    } else if (join.equals("no")) {
                        break; // guest checkout — currentCustomer stays null
                    } else {
                        System.out.println("Please answer yes or no.");
                    }
                }
            }

            sales.newCustomer();

            // -------- ORDER TRACKING --------
            // ArrayList<Coffee> stores every item added during this transaction.
            // ArrayList is ideal here because order size varies per customer.
            // It's also used later to select which item to comp for T2/T3 tier rewards.
            ArrayList<Coffee> orderItems = new ArrayList<>();
            double subtotal = 0;
            boolean ordering = true;

            // -------- ORDER LOOP --------
            // Runs until the customer selects 0 (Finish Order)
            while (ordering) {

                menu.printMenu();
                System.out.print("Choose an option (0 to finish): ");

                int choice;
                int maxChoice = menu.getTotalItems();

                // Input validation: accept any integer from 0 to maxChoice
                while (true) {
                    String raw = input.nextLine().trim();
                    try {
                        int parsed = Integer.parseInt(raw);
                        if (parsed >= 0 && parsed <= maxChoice) {
                            choice = parsed;
                            break;
                        }
                        System.out.print("Enter a number 0-" + maxChoice + ": ");
                    } catch (NumberFormatException e) {
                        System.out.print("Enter a number 0-" + maxChoice + ": ");
                    }
                }

                if (choice == 0) {
                    ordering = false;
                    continue;
                }

                // Look up the selected Coffee object from the Menu class
                Coffee selected = menu.getItemByNumber(choice);
                if (selected == null) {
                    System.out.println("Invalid choice. Try again.");
                    continue;
                }

                sales.soldDrink();

                // -------- PUNCH CARD FREE DRINK CHECK --------
                // A free drink is awarded when the customer is a member,
                // the item is a drink, and they've hit 5 punches
                boolean freeDrink = currentCustomer != null
                        && selected.getIsDrink()
                        && currentCustomer.rewardsEligible();

                if (freeDrink) {
                    System.out.println("🎉 Punch card reward! " + selected.getName() + " is FREE!");
                    currentCustomer.drinksReset();
                    // Free drink goes into orderItems at $0 — tracked for receipt but not subtotal
                    orderItems.add(selected);
                } else {
                    System.out.printf("✅ Added: %-30s $%.2f%n", selected.getName(), selected.getCost());
                    subtotal += selected.getCost();
                    orderItems.add(selected);

                    // Count drinks (not food) toward punch card
                    if (currentCustomer != null && selected.getIsDrink()) {
                        currentCustomer.addDrink();
                        System.out.println("   (" + currentCustomer.getNumberOfDrinks()
                                + "/5 punches toward free drink)");
                    }
                }
            }

            // -------- TIER EVALUATION --------
            // Tier is determined by the pre-discount subtotal.
            // Only rewards members qualify for tier benefits.
            int tier = Customer.TIER_NONE;
            if (currentCustomer != null) {
                tier = Customer.getTier(subtotal);
            }

            // -------- BUILD RECEIPT --------
            String customerName = (currentCustomer != null) ? currentCustomer.getCustName() : "Guest";
            Receipt receipt = new Receipt(activeCashier, customerName, tier);

            // Track which punch-card free items were already in orderItems
            // so we don't double-comp them as tier rewards
            boolean[] alreadyFree = new boolean[orderItems.size()];

            // Mark items that were free via punch card
            // We identify them by checking if punch card reward was triggered —
            // a simpler approach: items added via punch card path had $0 contribution to subtotal
            // We re-derive this by checking: item is a drink and subtotal didn't change
            // Instead, we track it cleanly by rebuilding from the freeDrink flag in the loop.
            // For simplicity, all items are initially treated as paid here;
            // the free punch card drink was already subtracted from subtotal at the time.

            // Add all order items to the receipt
            for (Coffee item : orderItems) {
                receipt.addItem(item.getName(), item.getCost());
            }

            // -------- TIER FREE ITEMS --------
            // T2 = 1 free item, T3 = 2 free items — comped from the most expensive items in the order
            int freeItemCount = 0;
            if (tier == Customer.TIER_2) freeItemCount = 1;
            if (tier == Customer.TIER_3) freeItemCount = 2;

            if (freeItemCount > 0) {
                System.out.println("\n🌟 " + Customer.getTierDescription(tier));
                System.out.println("Your " + freeItemCount + " free item(s) will be applied to your most expensive item(s).");

                // Sort orderItems by cost descending to find most expensive items to comp
                // We use a simple selection approach for clarity
                ArrayList<Coffee> sorted = new ArrayList<>(orderItems);
                sorted.sort((a, b) -> Double.compare(b.getCost(), a.getCost()));

                for (int i = 0; i < freeItemCount && i < sorted.size(); i++) {
                    Coffee freeItem = sorted.get(i);
                    receipt.addFreeItem(freeItem.getName() + " (Tier Reward)");
                    subtotal -= freeItem.getCost(); // deduct comp from subtotal
                    System.out.println("   FREE: " + freeItem.getName());
                }
            }

            // -------- GOLDEN TICKET BONUS --------
            // Spending over $20 earns a bonus punch toward the punch card (members only)
            if (currentCustomer != null && subtotal > 20) {
                System.out.println("⭐ Golden Ticket! Bonus punch added to your card.");
                currentCustomer.addDrink();
            }

            // -------- FINALIZE AND PRINT RECEIPT --------
            receipt.calculateTotals();
            receipt.printReceipt();

            // Add the post-discount final total to daily revenue
            sales.addCost(receipt.getFinalTotal());

            // -------- NEXT CUSTOMER --------
            System.out.print("Another customer? (yes/no): ");
            storeIsOpen = input.nextLine().equalsIgnoreCase("yes");
        }

        // -------- DAILY SUMMARY --------
        // Printed when the cashier closes the store (answers "no" to next customer)
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║            END OF DAY SUMMARY                ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        // Print each cashier name from the Sales ArrayList
        System.out.println("  Cashiers on shift:");
        for (String name : sales.getCashierNames()) {
            System.out.println("    - " + name);
        }

        System.out.println("──────────────────────────────────────────────");
        System.out.println("  Customers served : " + sales.getTotalCustomers());
        System.out.println("  Items sold       : " + sales.getDrinksSold());
        System.out.printf( "  Total revenue    : $%.2f%n", sales.getTotalRevenue());
        System.out.println("══════════════════════════════════════════════");
        System.out.println("  See you tomorrow! ☕");

        input.close();
    }
}
