package org.codedifferently;

// Concrete Person type used for employees whose work hours are tracked.
public class Employee extends Person {
    // Running total of employee hours.
    private double hoursworked;

    // Builds an employee with profile data plus starting hour balance.
    public Employee(int id, String firstname, String lastname, String email, double hoursworked){
        super(id, firstname, lastname, email);
        this.hoursworked=hoursworked;
    }

    @Override
// Returns a formatted, multi-line summary used by the menu print options.
    public String getSummary(){
        return "[Employee]" + " " + getFirstname() + " " + getLastname() + "\n"
                + "ID: " + getId() + "\n" + "Hours Worked" + " " + hoursworked;
    }

    // Replaces the current hour total with a new total.
    public void setHoursWorked(double hoursworked) {
        this.hoursworked = hoursworked;
    }

    // Returns the current hour total.
    public double getHoursworked() {
        return hoursworked;
    }
}

