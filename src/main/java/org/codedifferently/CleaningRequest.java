package org.codedifferently;

public class CleaningRequest extends ServiceRequest {
    private String cleaningArea;
    private int issueSeverity;

    public CleaningRequest() {
        super();
    }

    public CleaningRequest(String tenantName, String apartmentNumber, String cleaningArea, int issueSeverity) {
        super(tenantName, apartmentNumber);
        this.cleaningArea = cleaningArea;
        this.issueSeverity = issueSeverity;
    }

    @Override
    public String getRequestType() {
        return "Cleaning";
    }

    public String getCleaningArea() {
        return cleaningArea;
    }

    public int getIssueSeverity() {
        return issueSeverity;
    }

    public void setCleaningArea(String cleaningArea) {
        this.cleaningArea = cleaningArea;
    }

    public void setIssueSeverity(int issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

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