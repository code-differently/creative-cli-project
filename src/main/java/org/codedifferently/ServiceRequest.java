package org.codedifferently;

// Abstract class representing a general service request.
// Other request types (Maintenance, Cleaning) will inherit from this.
public abstract class ServiceRequest {

    // Protected so subclasses can access these fields
    protected String tenantName;
    protected String apartmentNumber;
    protected String status;

    // Default constructor
    // Every new request starts with status NEW
    public ServiceRequest() {
        this.status = "NEW";
    }

    // Constructor used when tenant name and apartment number are known
    public ServiceRequest(String tenantName, String apartmentNumber) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.status = "NEW";
    }

    // Getter methods
    public String getTenantName() {
        return tenantName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStatus() {
        return status;
    }

    // Setter methods
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    // Only allow valid status updates
    public void setStatus(String status) {
        if (status.equals("NEW") || status.equals("IN_PROGRESS") || status.equals("DONE")) {
            this.status = status;
        } else {
            System.out.println("INVALID STATUS UPDATE");
        }
    }

    // Abstract method that subclasses must implement
    // This allows different request types (Cleaning, Maintenance)
    public abstract String getRequestType();
}