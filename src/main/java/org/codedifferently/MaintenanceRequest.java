package org.codedifferently;

// MaintenanceRequest extends ServiceRequest
// This represents a repair or maintenance issue in an apartment
public class MaintenanceRequest extends ServiceRequest {

    // Type of maintenance issue (plumbing, electrical, etc.)
    private String issueType;

    // Severity level (1–5)
    private int issueSeverity;

    // Default constructor
    public MaintenanceRequest() {
        super(); // calls parent constructor
    }

    // Constructor with details
    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int issueSeverity) {
        super(tenantName, apartmentNumber);
        this.issueType = issueType;
        this.issueSeverity = issueSeverity;
    }

    // Overrides abstract method from ServiceRequest
    @Override
    public String getRequestType() {
        return "Maintenance";
    }

    // Getter methods
    public String getIssueType() {
        return issueType;
    }

    public int getIssueSeverity() {
        return issueSeverity;
    }

    // Setter methods
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setIssueSeverity(int issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

    // Converts the object to a readable string
    @Override
    public String toString() {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Type: " + getRequestType() +
                " | Issue: " + issueType +
                " | Severity: " + issueSeverity +
                " | Status: " + status;
    }
}