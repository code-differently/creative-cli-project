package org.codedifferently;

import java.util.ArrayList;

// BONUS CLASS — Menu centralizes all menu item definitions and display logic.
// By moving items out of Main into their own class, Main stays focused on program flow.
//
// ArrayList is used for each category because:
//   1. The number of items per category can grow without changing array sizes
//   2. We can loop over them generically for display and lookup
//   3. Items can be fetched by index number matching menu choices
//
// This class models how a real POS (Point of Sale) system would store menu data separately
// from the transaction logic.
public class Menu {

    // Separate ArrayLists per category allow organized menu sections.
    // Each list maps directly to a numbered menu section shown to the customer.
    private ArrayList<Coffee> hotDrinks   = new ArrayList<>();
    private ArrayList<Coffee> coldDrinks  = new ArrayList<>();
    private ArrayList<Coffee> blended     = new ArrayList<>();
    private ArrayList<Coffee> food        = new ArrayList<>();

    // Constructor populates all menu categories with Starbucks-inspired items.
    // All items are added here so Main only needs to create one Menu object.
    public Menu() {
        buildMenu();
    }

    // buildMenu defines every item in the shop.
    // Separating this into its own method keeps the constructor clean
    // and makes it easy to add new items later.
    private void buildMenu() {

        // ---- HOT DRINKS ----
        hotDrinks.add(new Coffee("Tall Latte",            2.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Grande Latte",          3.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Venti Latte",           5.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Tall Cappuccino",       2.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Grande Cappuccino",     3.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Tall Americano",        2.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Grande Americano",      3.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Tall Flat White",       2.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Tall Caramel Macchiato",2.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Pike Place Drip",       2.00, true, "Hot Drinks"));
        hotDrinks.add(new Coffee("Tall Chai Latte",       2.00, true, "Hot Drinks"));

        // ---- COLD DRINKS ----
        coldDrinks.add(new Coffee("Iced Tall Latte",           2.00, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Iced Grande Latte",         3.00, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Cold Brew",                 4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Nitro Cold Brew",           4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Iced Americano",            4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Iced Caramel Macchiato",    4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Iced Chai Latte",           4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Iced Matcha Latte",         4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Iced Brown Sugar Oat Milk", 4.75, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Refresher - Strawberry",    4.45, true, "Cold Drinks"));
        coldDrinks.add(new Coffee("Refresher - Mango Dragon",  4.45, true, "Cold Drinks"));

        // ---- BLENDED ----
        blended.add(new Coffee("Caramel Frappuccino - Tall",    2.00, true, "Blended"));
        blended.add(new Coffee("Caramel Frappuccino - Grande",  3.00, true, "Blended"));
        blended.add(new Coffee("Mocha Frappuccino - Tall",      2.00, true, "Blended"));
        blended.add(new Coffee("Mocha Frappuccino - Grande",    3.00, true, "Blended"));
        blended.add(new Coffee("Vanilla Bean Creme Frapp",      3.00, true, "Blended"));

        // ---- FOOD ----
        // isDrink = false → food items do NOT count toward the punch card
        food.add(new Coffee("Butter Croissant",          4.00, false, "Food"));
        food.add(new Coffee("Cheese Danish",             4.00, false, "Food"));
        food.add(new Coffee("Blueberry Muffin",          4.00, false, "Food"));
        food.add(new Coffee("Chocolate Chip Cookie",     4.00, false, "Food"));
        food.add(new Coffee("Avocado Spread Bagel",      4.00, false, "Food"));
        food.add(new Coffee("Spinach Feta Wrap",         4.00, false, "Food"));
        food.add(new Coffee("Egg & Cheddar Sandwich",    4.00, false, "Food"));
        food.add(new Coffee("Turkey Pesto Panini",       4.00, false, "Food"));
        food.add(new Coffee("Protein Box",               4.00, false, "Food"));
        food.add(new Coffee("Marshmallow Dream Bar",     4.00, false, "Food"));
    }

    // -------- DISPLAY --------
    // printMenu shows every category with numbered options.
    // Numbers are offset by section so the user always sees a continuous list.
    // The offset values must match the ranges used in getItemByNumber() below.
    public void printMenu() {
        System.out.println("\n  ╔══════════════════════════════════════════════╗");
        System.out.println("  ║            MONEY BUCKS COFFEE SHOP           ║");
        System.out.println("  ║     Inspired by the most expensive roasts ☕  ║");
        System.out.println("  ╚══════════════════════════════════════════════╝");

        // Each category prints with its own numbered offset so the user's input
        // maps cleanly to a single continuous list (1 through N)
        printCategory("☕ HOT DRINKS", hotDrinks, 1);
        printCategory("🧊 COLD DRINKS", coldDrinks, hotDrinks.size() + 1);
        printCategory("🥤 BLENDED", blended, hotDrinks.size() + coldDrinks.size() + 1);
        printCategory("🥐 FOOD", food, hotDrinks.size() + coldDrinks.size() + blended.size() + 1);

        System.out.println("\n  0. Finish Order");
        System.out.println("──────────────────────────────────────────────");
    }

    // Helper: prints one category section with a running number offset
    private void printCategory(String header, ArrayList<Coffee> items, int startNum) {
        System.out.println("\n  " + header);
        System.out.println("  " + "─".repeat(40));
        for (int i = 0; i < items.size(); i++) {
            Coffee item = items.get(i);
            // %-35s left-aligns the name; %5.2f right-aligns the price
            System.out.printf("  %2d. %-33s $%.2f%n",
                    startNum + i, item.getName(), item.getCost());
        }
    }

    // -------- ITEM LOOKUP --------
    // getItemByNumber maps the user's menu choice (1-based) to a Coffee object.
    // It calculates which list the number falls in using cumulative size offsets.
    // Returning null signals to Main that the input was out of range.
    public Coffee getItemByNumber(int num) {
        int hotEnd   = hotDrinks.size();
        int coldEnd  = hotEnd  + coldDrinks.size();
        int blendEnd = coldEnd + blended.size();
        int foodEnd  = blendEnd + food.size();

        if (num >= 1 && num <= hotEnd) {
            return hotDrinks.get(num - 1);
        } else if (num <= coldEnd) {
            return coldDrinks.get(num - hotEnd - 1);
        } else if (num <= blendEnd) {
            return blended.get(num - coldEnd - 1);
        } else if (num <= foodEnd) {
            return food.get(num - blendEnd - 1);
        }
        return null; // out of range
    }

    // Returns the total number of menu items across all categories
    public int getTotalItems() {
        return hotDrinks.size() + coldDrinks.size() + blended.size() + food.size();
    }

}