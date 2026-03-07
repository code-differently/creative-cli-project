package org.codedifferently;

package employeemanagement;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Console workflow class: handles login, menu options, and in-memory employee operations.
public class SiteSystem {

    // Constructor runs the application session loop for this project.
    public SiteSystem() {
        // Used to generate 3-digit employee IDs for new hires.
        Random random = new Random();

        // Scanner reads user input from console.
        Scanner scanner = new Scanner(System.in);
        // Primary in-memory list used for login and employee lookups.
        ArrayList<Person> people = new ArrayList<>();

        // Seed data for initial testing/demo records.
        siteManager Corey = new siteManager(872, "Corey", "Jones", "Cj98@gmail.com", "110 East 28th st Wilmiington De 19802 ");
        Employee employee1 = new Employee(872, "Corey", "Jones", "Cj98@gmail.com", 40.23);
        Employee employee2 = new Employee(221, "Kiya", "Smith", "Kiysm@icloud.com", 22.42);

        Employee employee3 = new Employee(429, "Kiya", "Smith", "Kiysm@icloud.com", 18.42);
        Employee employee4 = new Employee(192, "Jason", "Dozier", "Jdoz@gmail.com", 12.45);
        Corey.addemployee(employee3);
        Corey.addemployee(employee4);

        people.add(employee1);
        people.add(employee2);
        people.add(employee3);
        people.add(employee4);

        // Session loop continues until caller decides to stop (currently runs continuously).
        boolean done = false;

        while (!done) {

            System.out.println("======Welcome to OverSight======");
            System.out.println("\nPlease enter your ID number:");

            int identry = scanner.nextInt();

            // Tracks whether the entered ID matched anyone in the system.
            boolean found = false;

            for (Person p : people) {

                if (identry == p.getId()) {

                    found = true;

                    System.out.println("Welcome " + p.getFirstname() + ", what would you like to do today?");
                    System.out.println("1. Update your site location");
                    System.out.println("2. See employee hours worked");
                    System.out.println("3. Update employee hours");
                    System.out.println("4. Update new hire");
                    System.out.println("5. See all employees");
                    int choice = scanner.nextInt();

                    switch (choice) {

                        // Placeholder for future location-update feature.
                        case 1:
                            System.out.println("Updating site location...");
                            scanner.nextLine();
                            System.out.println("Please Enter Updated Site location. address, City, state, zipcode format:");
                            Corey.setLocation(scanner.nextLine());
                            System.out.println("You updated your location to:" + " " + Corey.getLocation());
                            break;

                        // Looks up one employee by ID and prints current hours.
                        case 2:
                            System.out.println("Viewing employee hours...");
                            scanner.nextLine();
                            System.out.println("Enter employee ID:");
                            int checkEmployeeHrs = scanner.nextInt();
                            boolean employeeFound = false;
                            for (Person dex : people) {
                                if (checkEmployeeHrs == dex.getId() && dex instanceof Employee) {
                                    Employee emp = (Employee) dex;
                                    System.out.println(emp.getFirstname() + " " + emp.getLastname()
                                            + " has " + emp.getHoursworked() + " hours.");
                                    employeeFound = true;
                                }
                            }
                            if (!employeeFound) {
                                System.out.println("Employee ID not found.");
                            }
                            break;

                        // Adds entered hours to an existing employee's hour total.
                        case 3:
                            System.out.println("Updating employee hours...");
                            scanner.nextLine();
                            System.out.println("Enter employee ID:");
                            int idcheck = scanner.nextInt();
                            boolean updated = false;
                            for (Person index : people) {
                                if (idcheck == index.getId() && index instanceof Employee) {
                                    Employee emp = (Employee) index;
                                    System.out.println("Enter hours to add:");
                                    double houradd = scanner.nextDouble();

                                    emp.setHoursWorked(emp.getHoursworked() + houradd);
                                    System.out.println(emp.getFirstname() + " " + "now has" + " " + emp.getHoursworked() + " " + "hours.");
                                    updated = true;
                                    break;
                                }
                            }
                            if (!updated) {
                                System.out.println("Employee ID not found.");
                            }
                            break;

                        // Creates and stores a new employee from console input.
                        case 4:
                            System.out.println("Adding new hire...");
                            scanner.nextLine();
                            System.out.println("Enter first name:");

                            String firstname = scanner.nextLine();
                            System.out.println("Enter last name:");

                            String lastname = scanner.nextLine();
                            System.out.println("Enter Email:");
                            String email = scanner.nextLine();
                            int n = random.nextInt(900) + 100;
                            Employee employeecreation = new Employee(n, firstname, lastname, email, 0.0);
                            people.add(employeecreation);
                            Corey.addemployee(employeecreation);
                            System.out.println(employeecreation.getSummary());
                            break;


                        // Prints summaries for all people currently in memory.
                        case 5:
                            for (Person person : people) {
                                System.out.println(person.getSummary());

                            }
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }

                    done = promptToExit(scanner);
                    if (done) {
                        System.out.println("Goodbye");
                    }

                    break;
                }
            }

            if (!found) {
                System.out.println("I'm sorry but that isn't a match, please try again.");
            }
        }
    }

    // Prompts once after each action so session flow is consistent across all menu options.
    private boolean promptToExit(Scanner scanner) {
        System.out.println("If you are finished enter 'done' to exit, to continue enter 'continue'");
        String doneOrContinue = scanner.next();
        return doneOrContinue.equalsIgnoreCase("done");
    }
}
