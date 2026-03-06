package org.codedifferently;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FitnessApp {
    private static ArrayList<Person> users = new ArrayList<>();
    public static void startApp(Scanner sc) {
        System.out.println("Welcome to LiftLogic!");
        int input;

        // Stores appointment data for generating a journal upon exit.

        do {
            // Displays the main menu options to the user.
            System.out.println("\n=== Barber Shop Management Menu ===");
            System.out.println("1) Signup");
            System.out.println("2) Login");
            System.out.println("0) Quit");
            System.out.print("Choose: ");

            // Validates numeric input before processing.
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            } else {
                input = -1;
            }
            sc.nextLine();

            String name;
            String phoneNumber;

            switch (input) {
                // Handles the creation and storage of a new customer.
                case 1:
                    signup(sc);
                    break;
                // Displays the full list of registered customers.
                case 2:
                    Person toLogin = validateLogin(sc);
                    if (toLogin != null) {
                        login(toLogin);
                    } else {
                        System.out.println("Invalid username or password. Try again.");
                    }
                    break;
                // Exits the system and prints a journal of completed appointments.
                case 0:
                    System.out.println("\nExiting system...");
                    break;
                // Handles invalid menu selections.
                default:
                    System.out.println("\nPlease select a valid option.");
            }
            // Stopping condition. Program will exit when the user inputs 0.
        } while (input != 0);
    }

    private static void signup(Scanner sc) {
        String name = validateName(sc);
        String email = validateEmail(sc);
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        Person user = new Person(name, email, password);
        users.add(user);
        FitnessApp.login(user);
    }

    public static void login(Person person) {

    }

    // Searches for a customer using their phone number and returns the match if found.
    public static Person validateLogin(Scanner sc) {
        String email = validateEmail(sc);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        for (Person user : FitnessApp.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Validates that the user's name input contains only permitted characters.
    public static String validateName(Scanner sc) {
        // Repeats continuously until valid input is provided.
        while (true) {
            // Prompts the user to enter their name.
            System.out.print("\nEnter a name: ");
            String name = sc.nextLine();

            // Checks whether the input matches the required name pattern.
            // Allows letters and optionally single spaces, hyphens, or apostrophes between words.
            if (name.matches("^[a-zA-Z]+([ '-][a-zA-Z]+)*$")) {
                // Returns the validated name if it meets the pattern requirements.
                return name;
            } else {
                // Displays an error message if validation fails.
                System.out.println("\nInvalid name. Please use letters only.");
            }
        }
    }

    public static String validateEmail(Scanner sc) {
        // Prompts the user for a valid email address for the order. Will launch an error if it is invalid.
        while (true) {
            System.out.print("Enter your email address?: ");
            String email = sc.nextLine();
            try {
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                    throw new IllegalArgumentException();
                } else {
                    return email;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nInvalid email address. Try again.\n");
            }
        }
    }

    public static ArrayList<Person> getUsers() {
        return users;
    }
}
