package org.codedifferently;

public class MaintenanceRequest extends ServiceRequest {
    private String issueType;
    private int issueSeverity;

    public MaintenanceRequest() {
        super();
    }

    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int issueSeverity) {
        super(tenantName, apartmentNumber);
        this.issueType = issueType;
        this.issueSeverity = issueSeverity;
    }

    @Override
    public String getRequestType() {
        return "Maintenance";
    }

    public String getIssueType() {
        return issueType;
    }

    public int getIssueSeverity() {
        return issueSeverity;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setIssueSeverity(int issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

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