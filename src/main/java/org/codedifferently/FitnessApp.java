package org.codedifferently;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FitnessApp {
    private static ArrayList<Person> users = new ArrayList<>();
    public static void startApp(Scanner sc) {
        System.out.println("Welcome to LiftLogic!");
        int input;

        // Stores appointment data for generating a journal upon exit.

        do {
            // Displays the main menu options to the user.
            System.out.println("\n=== LiftLogic ===");
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

            switch (input) {
                // Handles the creation and storage of a new customer.
                case 1:
                    signup(sc);
                    break;
                // Displays the full list of registered customers.
                case 2:
                    Person toLogin = validateLogin(sc);
                    if (toLogin != null) {
                        login(toLogin, sc);
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
        FitnessApp.login(user, sc);
    }

    public static void login(Person person, Scanner sc) {
        System.out.println("Welcome, " + person.getName() + "!");
        int input;

        do {
            // Displays the main menu options to the user.
            System.out.println("\n=== LiftLogic ===");
            System.out.println("1) Log a workout");
            System.out.println("2) Display Leaderboard");
            System.out.println("3) Settings");
            System.out.println("0) Logout");
            System.out.print("Choose: ");

            // Validates numeric input before processing.
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            } else {
                input = -1;
            }
            sc.nextLine();

            switch (input) {
                // Handles the creation and storage of a new customer.
                case 1:
                    Workout workout = createWorkout(sc);
                    ArrayList<Workout> workouts = person.getWorkouts();
                    workouts.add(workout);
                    person.setWorkouts(workouts);
                    person.setActiveWorkout(workout);
                    break;
                // Displays the full list of registered customers.
                case 2:
                    break;
                // Exits the system and prints a journal of completed appointments.
                case 3:
                    displaySettings(person, sc);
                    break;
                case 0:
                    System.out.println("\nLogging out...");
                    break;
                // Handles invalid menu selections.
                default:
                    System.out.println("\nPlease select a valid option.");
            }
            // Stopping condition. Program will exit when the user inputs 0.
        } while (input != 0);
    }

    public static void displaySettings(Person person, Scanner sc) {
        int input;
        do {
            System.out.println("\n=== Settings ===");
            System.out.println("1) Change Name");
            System.out.println("2) Reset Password");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            // Validates numeric input before processing.
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            } else {
                input = -1;
            }
            sc.nextLine();

            switch (input) {
                // Handles the creation and storage of a new customer.
                case 1:
                    String name = validateName(sc);
                    person.setName(name);
                    break;
                // Displays the full list of registered customers.
                case 2:
                    System.out.print("Enter your current password: ");
                    String password = sc.nextLine();
                    if (person.getPassword().equals(password)) {
                        System.out.print("Enter your new password: ");
                        String pass1 = sc.nextLine();
                        System.out.print("Enter your new password again: ");
                        String pass2 = sc.nextLine();

                        if (pass1.equals(pass2)) {
                            person.setPassword(password);
                        } else {
                            System.out.println("Passwords did not match.");
                        }
                    } else {
                        System.out.println("Invalid password.");
                    }
                case 0:
                    System.out.println("\nExiting settings...");
                    break;
                // Handles invalid menu selections.
                default:
                    System.out.println("\nPlease select a valid option.");
            }
            // Stopping condition. Program will exit when the user inputs 0.
        } while (input != 0);
    }

    public static Workout createWorkout(Scanner scanner) {
        System.out.println("Create New Workout");

        System.out.print("Enter workout duration: ");
        String duration = scanner.nextLine();

        Date date = new Date();

        Workout workout = new Workout(duration, date, new ArrayList<>());

        // Ask how many exercises the workout contains
        System.out.print("How many exercises are in this workout? ");
        int exerciseCount = scanner.nextInt();
        scanner.nextLine(); // clear newline

        for (int i = 0; i < exerciseCount; i++) {

            System.out.println("\nExercise " + (i + 1));

            // Ask for exercise name
            System.out.print("Enter exercise name: ");
            String name = scanner.nextLine();

            // Ask for calories burned
            System.out.print("Enter calories burned: ");
            int calories = scanner.nextInt();
            scanner.nextLine(); // clear newline

            // Display enum exercise types
            System.out.println("Select Exercise Type:");

            ExerciseType[] types = ExerciseType.values();

            for (int j = 0; j < types.length; j++) {
                System.out.println((j + 1) + ". " + types[j]);
            }

            int typeChoice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            ExerciseType selectedType = types[typeChoice - 1];

            Exercise exercise = new Exercise(selectedType, name, calories);

            workout.addExercise(exercise);
        }
        return workout;
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
