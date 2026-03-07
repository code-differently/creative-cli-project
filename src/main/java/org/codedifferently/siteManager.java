package org.codedifferently;

import java.util.ArrayList;

// Manager role that tracks on-site location and a list of assigned employees.
public class siteManager extends Person{
    // Current location text for this manager.
    private String location;
    // Employees currently assigned to this manager/site.
    private ArrayList<Employee> employeesonsite;
    // Counter used when printing summary details.
    private int totalemployees;

    // Initializes manager profile, location, and an empty employee list.
    public siteManager(int id, String firstname, String lastname, String email, String location){
        super(id, firstname, lastname, email);
        this.location=location;
        this.employeesonsite= new ArrayList<>();
        this.totalemployees=totalemployees;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    // Adds an employee object to the manager's on-site roster.
    public void addemployee(Employee employee){
        employeesonsite.add(employee);
    }
    @Override
    // Prints each employee summary and manager details, then returns a total count label.
    public String getSummary() {
        for (Employee e : employeesonsite) {
            ++totalemployees;
            System.out.println("\n" + e.getSummary());
            System.out.println("[Site Manager]" + getFirstname() + " " + getLastname()
                    + "\n" + " Location: " + location);

        }
        return "Total employees" + " " + totalemployees;

    }

}
