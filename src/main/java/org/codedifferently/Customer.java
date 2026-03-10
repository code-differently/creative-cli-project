package org.codedifferently;

import java.io.Serializable;
import java.util.UUID;

public class Customer implements Serializable {
    private String name;
    private String ID;
    private boolean isCheckedIn;

    public Customer(String name) {
        this.name = name;
        this.ID = generateID(name);
        this.isCheckedIn = false;
    }

    private String generateID(String name) {
        return name.substring(0,1).toUpperCase() + UUID.randomUUID().toString().substring(0,5);
    }

    public String getName() { return name; }
    public String getID() { return ID; }
    public boolean isCheckedIn() { return isCheckedIn; }

    public void checkIn() { this.isCheckedIn = true; }
    public void checkOut() { this.isCheckedIn = false; }

    @Override
    public String toString() {
        return "Customer ID: " + ID + ", Name: " + name + ", Checked-in: " + isCheckedIn;
    }
}
