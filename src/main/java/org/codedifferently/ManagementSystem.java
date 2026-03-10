package org.codedifferently;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// store customers & appointments in ArrayList because the list can expand and store different data types
// Use Map for local date & time ( key - value)
public class ManagementSystem implements Serializable {
    private ArrayList<Customer> customers;
    private ArrayList<Appointment> appointments;
    private HashMap<LocalDateTime, ArrayList<String>> waitlistMap;

    public ManagementSystem() {
        customers = new ArrayList<>();
        appointments = new ArrayList<>();
        waitlistMap = new HashMap<>();
    }

    // ---------------- Customer Methods ----------------
    public void addCustomer(String name) {
        Customer customer = new Customer(name);
        customers.add(customer);
    }

    public Customer searchCustomer(String idOrName) {
        for (Customer c : customers) {
            if (c.getID().equalsIgnoreCase(idOrName) || c.getName().equalsIgnoreCase(idOrName))
                return c;
        }
        return null;
    }


    public void checkInCustomer(String idOrName) {
        Customer c = searchCustomer(idOrName);
        if (c != null) c.checkIn();
    }

    public ArrayList<Customer> getCustomers() { return customers; }

    // ---------------- Appointment Methods ----------------
    public boolean isSlotAvailable(LocalDateTime slotTime) {
        for (Appointment a : appointments) {
            if (a.getTime().equals(slotTime)) return false;
        }
        return true;
    }

    public void scheduleAppointment(String customerID, LocalDateTime slotTime) {
        if (isSlotAvailable(slotTime)) {
            appointments.add(new Appointment(customerID, slotTime));
        } else {
            waitlistMap.putIfAbsent(slotTime, new ArrayList<>());
            waitlistMap.get(slotTime).add(customerID);
        }
    }

    public void completeAppointment(String customerID, LocalDateTime slotTime) {
        for (Appointment a : appointments) {
            if (a.getCustomerID().equalsIgnoreCase(customerID) && a.getTime().equals(slotTime)) {
                a.complete();
                promoteWaitlist(slotTime);
                return;
            }
        }
    }

    public void cancelAppointment(String customerID, LocalDateTime slotTime) {
        Appointment toRemove = null;
        for (Appointment a : appointments) {
            if (a.getCustomerID().equalsIgnoreCase(customerID) && a.getTime().equals(slotTime)) {
                toRemove = a;
                break;
            }
        }
        if (toRemove != null) {
            appointments.remove(toRemove);
            promoteWaitlist(slotTime);
        } else if (waitlistMap.containsKey(slotTime)) {
            waitlistMap.get(slotTime).remove(customerID);
        }
    }

    private void promoteWaitlist(LocalDateTime slotTime) {
        if (waitlistMap.containsKey(slotTime) && !waitlistMap.get(slotTime).isEmpty()) {
            String nextCustomer = waitlistMap.get(slotTime).remove(0);
            appointments.add(new Appointment(nextCustomer, slotTime));
        }
    }

    public ArrayList<Appointment> getAppointments() { return appointments; }
    public HashMap<LocalDateTime, ArrayList<String>> getWaitlistMap() { return waitlistMap; }

    public List<String> getCustomerNamesForSlot(LocalDateTime slotTime) {
        List<String> names = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getTime().equals(slotTime)) {
                Customer c = searchCustomer(a.getCustomerID());
                names.add(c != null ? c.getName() : a.getCustomerID());
            }
        }
        return names;
    }

    // ---------------- Persistence to store data in a file----------------
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("managementdata.ser"))) {

            oos.writeObject(this);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static ManagementSystem loadData() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("managementdata.ser"))) {
            return (ManagementSystem) ois.readObject();
        } catch (Exception e) { return new ManagementSystem(); }
    }
}
