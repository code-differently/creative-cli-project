package org.codedifferently;

// CleaningRequest represents cleaning services for an apartment
public class CleaningRequest extends ServiceRequest {

    // Area that needs cleaning
    private String cleaningArea;

    // Severity level of cleaning request
    private int issueSeverity;

    // Default constructor
    public CleaningRequest() {
        super();
    }

    // Constructor with parameters
    public CleaningRequest(String tenantName, String apartmentNumber, String cleaningArea, int issueSeverity) {
        super(tenantName, apartmentNumber);
        this.cleaningArea = cleaningArea;
        this.issueSeverity = issueSeverity;
    }

    // Overrides abstract method
    @Override
    public String getRequestType() {
        return "Cleaning";
    }

    // Getter methods
    public String getCleaningArea() {
        return cleaningArea;
    }

    public int getIssueSeverity() {
        return issueSeverity;
    }

    // Setter methods
    public void setCleaningArea(String cleaningArea) {
        this.cleaningArea = cleaningArea;
    }

    public void setIssueSeverity(int issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

    // Convert object into readable string
    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Type: " + getRequestType() +
                " | Area: " + cleaningArea +
                " | Severity: " + issueSeverity +
                " | Status: " + status;
    }
}