package org.codedifferently;

import java.util.Scanner;

public class Venue {
        private String name;
        private String city;
        private int capacity;


        Scanner sc = new Scanner(System.in);

        public Venue() {
        }

        public Venue(String name, String city, int capacity) {
            this.name = name;
            this.city = city;
            this.capacity = capacity;

        }
        public Venue promptNewVenue(){
            System.out.println("Enter name of gig venue: ");
            String venueName = sc.nextLine();

            System.out.println("Enter name of city/state of venue: ");
            String city = sc.nextLine();

            System.out.println("Enter venue capacity: ");
            int capacity = sc.nextInt();
            sc.nextLine(); // CLEAR NEWLINE


            return new Venue(venueName,city,capacity);
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





        @Override
        public String toString() {
            return name + " - " + city + " | Capacity: " + capacity;
        }
    }

