package org.codedifferently;

// Coffee represents a single menu item — drinks OR food.
// The category field (e.g. "Hot Drinks", "Cold Drinks", "Food") groups items
// for organized menu display and receipt sections.
// isDrink controls whether the item counts toward the rewards punch card.
public class Coffee {

    private String name;
    private double cost;
    private boolean isDrink;

    // Category is used by the Menu class to group and display items by section.
    // Keeping it on the Coffee object means Menu doesn't need to hardcode groupings.
    private String category;

    // Full constructor — all menu items are fully defined at creation time.
    // No setters needed because menu items don't change during runtime.
    public Coffee(String name, double cost, boolean isDrink, String category) {
        this.name = name;
        this.cost = cost;
        this.isDrink = isDrink;
        this.category = category;
    }

    // Backward-compatible constructor for items without an explicit category
    public Coffee(String name, double cost, boolean isDrink) {
        this(name, cost, isDrink, "Other");
    }

    // -------- GETTERS --------

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public boolean getIsDrink() {
        return isDrink;
    }

    public String getCategory() {
        return category;
    }
}