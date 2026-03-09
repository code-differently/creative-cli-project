package org.codedifferently;

public class Venue {
        private String name;
        private String city;
        private int capacity;
        private String contactName;
        private String contactEmail;

        public Venue() {
        }

        public Venue(String name, String city, int capacity, String contactName, String contactEmail) {
            this.name = name;
            this.city = city;
            this.capacity = capacity;
            this.contactName = contactName;
            this.contactEmail = contactEmail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        @Override
        public String toString() {
            return name + " - " + city + " | Capacity: " + capacity +
                    " | Contact: " + contactName + " | Email: " + contactEmail;
        }
    }

