package org.codedifferently;

public abstract class ServiceRequest {

        protected String residentName;
        protected int apartmentNumber;
        protected String severity;
        protected String status;

        public ServiceRequest(String residentName, int apartmentNumber, String severity) {
            this.residentName = residentName;
            this.apartmentNumber = apartmentNumber;
            this.severity = severity;
            this.status = "NEW";
        }

        public String getResidentName() {
            return residentName;
        }

        public int getApartmentNumber() {
            return apartmentNumber;
        }

        public String getSeverity() {
            return severity;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public abstract String getRequestType();

        @Override
        public String toString() {
            return getRequestType() +
                    " | Resident: " + residentName +
                    " | Apt: " + apartmentNumber +
                    " | Severity: " + severity +
                    " | Status: " + status;
        }
    }

