package org.codedifferently;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Appointment implements Serializable {
    private String customerID;
    private LocalDateTime time;
    private boolean isCompleted;

    public Appointment(String customerID, LocalDateTime time) {
        this.customerID = customerID;
        this.time = time;
        this.isCompleted = false;
    }

    public String getCustomerID() { return customerID; }
    public LocalDateTime getTime() { return time; }
    public boolean isCompleted() { return isCompleted; }

    public void complete() { this.isCompleted = true; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Appointment | Customer ID: " + customerID +
                " | Time: " + time.format(formatter) +
                " | Completed: " + isCompleted;
    }
}
