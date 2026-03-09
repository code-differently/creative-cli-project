package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ServiceRequest> requests = new ArrayList<>();
        ArrayList<ResidentAccount> accounts = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Apartment Service & Payment System ===");
            System.out.println("1. Add Resident Account");
            System.out.println("2. Submit Maintenance Request");
            System.out.println("3. Submit Cleaning Request");
            System.out.println("4. View All Requests");
            System.out.println("5. Update Request Status");
            System.out.println("6. View Resident Accounts");
            System.out.println("7. Make Payment");
            System.out.println("8. Daily Report");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("Please enter a number.");
                scan.nextLine();
                continue;
            }
//
            switch (choice) {
                case 1:
                    addResidentAccount(accounts, scan);
                    break;
                case 2:
                    addMaintenanceRequest(requests, accounts, scan);
                    break;
                case 3:
                    addCleaningRequest(requests, accounts, scan);
                    break;
                case 4:
                    viewAllRequests(requests);
                    break;
                case 5:
                    updateRequestStatus(requests, scan);
                    break;
                case 6:
                    viewResidentAccounts(accounts);
                    break;
                case 7:
                    makePayment(accounts, scan);
                    break;
                case 8:
                    dailyReport(requests, accounts);
                    break;
                case 9:
                    running = false;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scan.close();
    }

    public static void addResidentAccount(ArrayList<ResidentAccount> accounts, Scanner scan) {
        System.out.print("Enter resident name: ");
        String name = scan.nextLine();

        System.out.print("Enter apartment number: ");
        String apartmentNumber = scan.nextLine();

        System.out.print("Enter starting balance: ");
        double balance = readDouble(scan);

        ResidentAccount account = new ResidentAccount(name, apartmentNumber, balance);
        accounts.add(account);

        System.out.println("Resident account added.");
    }

    public static void addMaintenanceRequest(ArrayList<ServiceRequest> requests,
                                             ArrayList<ResidentAccount> accounts,
                                             Scanner scan) {
        System.out.print("Enter tenant name: ");
        String tenantName = scan.nextLine();

        System.out.print("Enter apartment number: ");
        String apartmentNumber = scan.nextLine();

        System.out.print("Enter issue type: ");
        String issueType = scan.nextLine();

        System.out.print("Enter issue severity (1-5): ");
        int severity = readInt(scan);

        MaintenanceRequest request = new MaintenanceRequest(tenantName, apartmentNumber, issueType, severity);
        requests.add(request);

        ResidentAccount account = findAccount(accounts, apartmentNumber);
        if (account != null) {
            account.addCharge(15.00);
            System.out.println("Maintenance request submitted. $15.00 charge added.");
        } else {
            System.out.println("Maintenance request submitted. No matching resident account found.");
        }
    }

    public static void addCleaningRequest(ArrayList<ServiceRequest> requests,
                                          ArrayList<ResidentAccount> accounts,
                                          Scanner scan) {
        System.out.print("Enter tenant name: ");
        String tenantName = scan.nextLine();

        System.out.print("Enter apartment number: ");
        String apartmentNumber = scan.nextLine();

        System.out.print("Enter cleaning area: ");
        String cleaningArea = scan.nextLine();

        System.out.print("Enter severity (1-5): ");
        int severity = readInt(scan);

        CleaningRequest request = new CleaningRequest(tenantName, apartmentNumber, cleaningArea, severity);
        requests.add(request);

        ResidentAccount account = findAccount(accounts, apartmentNumber);
        if (account != null) {
            account.addCharge(25.00);
            System.out.println("Cleaning request submitted. $25.00 charge added.");
        } else {
            System.out.println("Cleaning request submitted. No matching resident account found.");
        }
    }

    public static void viewAllRequests(ArrayList<ServiceRequest> requests) {
        if (requests.isEmpty()) {
            System.out.println("No requests found.");
            return;
        }

        System.out.println("\n--- ALL REQUESTS ---");
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) + ". " + requests.get(i));
        }
    }

    public static void updateRequestStatus(ArrayList<ServiceRequest> requests, Scanner scan) {
        if (requests.isEmpty()) {
            System.out.println("No requests to update.");
            return;
        }

        viewAllRequests(requests);
        System.out.print("Choose request number to update: ");
        int choice = readInt(scan);

        if (choice < 1 || choice > requests.size()) {
            System.out.println("Invalid request number.");
            return;
        }

        ServiceRequest request = requests.get(choice - 1);

        if (request.getStatus().equals("NEW")) {
            request.setStatus("IN_PROGRESS");
        } else if (request.getStatus().equals("IN_PROGRESS")) {
            request.setStatus("DONE");
        } else {
            System.out.println("Request is already DONE.");
            return;
        }

        System.out.println("Updated request:");
        System.out.println(request);
    }

    public static void viewResidentAccounts(ArrayList<ResidentAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No resident accounts found.");
            return;
        }

        System.out.println("\n--- RESIDENT ACCOUNTS ---");
        for (ResidentAccount account : accounts) {
            System.out.println(account);
        }
    }

    public static void makePayment(ArrayList<ResidentAccount> accounts, Scanner scan) {
        if (accounts.isEmpty()) {
            System.out.println("No resident accounts available.");
            return;
        }

        System.out.print("Enter apartment number: ");
        String apartmentNumber = scan.nextLine();

        ResidentAccount account = findAccount(accounts, apartmentNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter payment amount: ");
        double amount = readDouble(scan);

        account.makePayment(amount);
        System.out.println("Updated account:");
        System.out.println(account);
    }

    public static void dailyReport(ArrayList<ServiceRequest> requests, ArrayList<ResidentAccount> accounts) {
        int newCount = 0;
        int inProgressCount = 0;
        int doneCount = 0;
        int maintenanceCount = 0;
        int cleaningCount = 0;

        for (ServiceRequest request : requests) {
            if (request.getStatus().equals("NEW")) {
                newCount++;
            } else if (request.getStatus().equals("IN_PROGRESS")) {
                inProgressCount++;
            } else if (request.getStatus().equals("DONE")) {
                doneCount++;
            }

            if (request.getRequestType().equals("Maintenance")) {
                maintenanceCount++;
            } else if (request.getRequestType().equals("Cleaning")) {
                cleaningCount++;
            }
        }

        System.out.println("\n--- DAILY REPORT ---");
        System.out.println("Total Requests: " + requests.size());
        System.out.println("Maintenance Requests: " + maintenanceCount);
        System.out.println("Cleaning Requests: " + cleaningCount);
        System.out.println("NEW: " + newCount);
        System.out.println("IN_PROGRESS: " + inProgressCount);
        System.out.println("DONE: " + doneCount);
        System.out.println("Resident Accounts: " + accounts.size());
    }

    public static ResidentAccount findAccount(ArrayList<ResidentAccount> accounts, String apartmentNumber) {
        for (ResidentAccount account : accounts) {
            if (account.getApartmentNumber().equals(apartmentNumber)) {
                return account;
            }
        }
        return null;
    }

    public static int readInt(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("Please enter a valid whole number.");
            scan.nextLine();
        }
        int value = scan.nextInt();
        scan.nextLine();
        return value;
    }

    public static double readDouble(Scanner scan) {
        while (!scan.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            scan.nextLine();
        }
        double value = scan.nextDouble();
        scan.nextLine();
        return value;
    }
}