package org.codedifferently;

public class MaintenanceRequest {
    private String tenantName;
    private String apartmentNumber;
    private String issueType;
    private int issueSeverity;
    private String status;

    public MaintenanceRequest() {
        this.status = "NEW";
    }

    public MaintenanceRequest(String tenantName, String apartmentNumber, String issueType, int issueSeverity) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.issueType = issueType;
        this.issueSeverity = issueSeverity;
        this.status = "NEW";
    }

    //getters
    public String getTenantName() {
        return tenantName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public int getIssueSeverity() {
        return issueSeverity;
    }


    public String getStatus() {
        return status;
    }

    //setters
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setIssueSeverity(int issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

    public void setStatus(String status) {
        if (status.equals("NEW") || status.equals("IN PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            System.out.println("INVALID STATUS UPDATE");
        }
    }

    @Override
    public String toString () {
        return "Tenant: " + tenantName +
                " | Apt: " + apartmentNumber +
                " | Issue: " + issueType +
                " | Severity: " + issueSeverity +
                " | Status: " + status;
    }


}


