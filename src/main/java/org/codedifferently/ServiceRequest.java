package org.codedifferently;

public abstract class ServiceRequest {
    protected String tenantName;
    protected String apartmentNumber;
    protected String status;

    public ServiceRequest() {
        this.status = "NEW";
    }

    public ServiceRequest(String tenantName, String apartmentNumber) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.status = "NEW";
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setStatus(String status) {
        if (status.equals("NEW") || status.equals("IN_PROGRESS") || status.equals("DONE")) {
            this.status = status;
        } else {
            System.out.println("INVALID STATUS UPDATE");
        }
    }

    public abstract String getRequestType();
}