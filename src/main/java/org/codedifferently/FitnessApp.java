package org.codedifferently;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// Manages the main workflow of the LiftLogic fitness application
public class FitnessApp {

    // Stores all registered users in the system
    private static ArrayList<Person> users = new ArrayList<>();

    // Starts the application and displays the main menu
    public static void startApp(Scanner sc) {
        System.out.println("Welcome to LiftLogic!");
        int input;

        do {
            // Displays main menu options
            System.out.println("\n=== LiftLogic ===");
            System.out.println("1) Signup");
            System.out.println("2) Login");
            System.out.println("0) Quit");
            System.out.print("Choose: ");

            // Validates numeric menu input
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            } else {
                input = -1;
            }
            sc.nextLine();

            switch (input) {

                // Creates a new user account
                case 1:
                    signup(sc);
                    break;

                // Attempts user login
                case 2:
                    Person toLogin = validateLogin(sc);
                    if (toLogin != null) {
                        login(toLogin, sc);
                    } else {
                        System.out.println("Invalid username or password. Try again.");
                    }
                    break;

                // Exits the application
                case 0:
                    System.out.println("\nExiting system...");
                    break;

                // Handles invalid selections
                default:
                    System.out.println("\nPlease select a valid option.");
            }

        } while (input != 0);
    }

    // Registers a new user and logs them in
    private static void signup(Scanner sc) {
        String name = validateName(sc);
        String email = validateEmail(sc);
        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        Person user = new Person(name, email, password);
        users.add(user);

        // Logs the new user into the system
        FitnessApp.login(user, sc);
    }

    // Displays the logged-in user menu
    public static void login(Person person, Scanner sc) {
        System.out.println("Welcome, " + person.getName() + "!");
        int input;

        do {
            // Displays user dashboard menu
            System.out.println("\n=== LiftLogic ===");
            System.out.println("1) Log a workout");
            System.out.println("2) Display Leaderboard");
            System.out.println("3) Settings");
            System.out.println("0) Logout");
            System.out.print("Choose: ");

            // Validates numeric input
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            } else {
                input = -1;
            }
            sc.nextLine();

            switch (input) {

                // Creates and stores a workout for the user
                case 1:
                    Workout workout = createWorkout(sc);
                    ArrayList<Workout> workouts = person.getWorkouts();
                    workouts.add(workout);
                    person.setWorkouts(workouts);
                    person.setActiveWorkout(workout);
                    break;

                // Displays leaderboard (feature placeholder)
                case 2:
                    displayLeaderboard(getUsers());
                    break;
                // Opens user settings
                case 3:
                    displaySettings(person, sc);
                    break;

                // Logs the user out
                case 0:
                    System.out.println("\nLogging out...");
                    break;

                // Handles invalid selections
                default:
                    System.out.println("\nPlease select a valid option.");
            }

        } while (input != 0);
    }

    // Displays and processes user settings
    public static void displaySettings(Person person, Scanner sc) {
        int input;

        do {
            // Displays settings menu
            System.out.println("\n=== Settings ===");
            System.out.println("1) Change Name");
            System.out.println("2) Reset Password");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            // Validates numeric input
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            } else {
                input = -1;
            }
            sc.nextLine();

            switch (input) {

                // Updates the user's name
                case 1:
                    String name = validateName(sc);
                    person.setName(name);
                    break;

                // Updates the user's password after verification
                case 2:
                    System.out.print("Enter your current password: ");
                    String password = sc.nextLine();

                    if (person.getPassword().equals(password)) {
                        System.out.print("Enter your new password: ");
                        String pass1 = sc.nextLine();
                        System.out.print("Enter your new password again: ");
                        String pass2 = sc.nextLine();

                        if (pass1.equals(pass2)) {
                            person.setPassword(pass1);
                        } else {
                            System.out.println("Passwords did not match.");
                        }
                    } else {
                        System.out.println("Invalid password.");
                    }
                    break;
                    // Exits settings menu
                case 0:
                    System.out.println("\nExiting settings...");
                    break;

                // Handles invalid selections
                default:
                    System.out.println("\nPlease select a valid option.");
            }

        } while (input != 0);
    }

    // Creates a workout and collects exercise information
    public static Workout createWorkout(Scanner scanner) {

        System.out.println("Create New Workout");

        // Collects workout duration
        System.out.print("Enter workout duration: ");
        String duration = scanner.nextLine();

        // Records workout date
        Date date = new Date();

        // Initializes workout object
        Workout workout = new Workout(duration, date);

        // Asks how many exercises to log
        System.out.print("How many exercises are in this workout? ");
        int exerciseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < exerciseCount; i++) {

            // Collects exercise name
            System.out.println("\nExercise " + (i + 1));
            System.out.print("Enter exercise name: ");
            String name = scanner.nextLine();

            // Collects calories burned
            System.out.print("Enter calories burned: ");
            int calories = scanner.nextInt();
            scanner.nextLine();

            // Displays exercise type options
            System.out.println("Select Exercise Type:");
            ExerciseType[] types = ExerciseType.values();

            for (int j = 0; j < types.length; j++) {
                System.out.println((j + 1) + ". " + types[j]);
            }

            // Converts user selection to enum value
            int typeChoice = scanner.nextInt();
            scanner.nextLine();
            ExerciseType selectedType = types[typeChoice - 1];

            // Creates and adds exercise to workout
            Exercise exercise = new Exercise(selectedType, name, calories);
            workout.addExercise(exercise);
        }

        return workout;
    }

    // Validates login credentials and returns the matching user
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

    // Validates name input using a regex pattern
    public static String validateName(Scanner sc) {

        while (true) {

            System.out.print("\nEnter a name: ");
            String name = sc.nextLine();

            // Checks name formatting rules
            if (name.matches("^[a-zA-Z]+([ '-][a-zA-Z]+)*$")) {
                return name;
            } else {
                System.out.println("\nInvalid name. Please use letters only.");
            }
        }
    }

    // Validates email format using regex
    public static String validateEmail(Scanner sc) {

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

    // Returns the list of registered users
    public static ArrayList<Person> getUsers() {
        return users;
    }


    public static Person getMaxKey(Map<Person, Integer> map) {
        int maxExercises = -1;
        Person maxPerson = null;

        for (Person person : map.keySet()) {
            if (map.get(person) > maxExercises) {
                maxExercises = map.get(person);
                maxPerson = person;
            }
        }

        return maxPerson;
    }

    public static int countExercises(Person person) {
        int count = 0;

        for (Workout workout : person.getWorkouts()) {
            count += workout.getExercises().size();
        }

        return count;
    }

    public static ArrayList<Person> buildLeaderboard(Map<Person, Integer> map) {
        ArrayList<Person> leaderboard = new ArrayList<>();

        while (!map.isEmpty()) {
            Person maxPerson = getMaxKey(map);
            leaderboard.add(maxPerson);
            map.remove(maxPerson);
        }

        return leaderboard;
    }

    public static void displayLeaderboard(ArrayList<Person> people) {

        Map<Person, Integer> map = new LinkedHashMap<>();

        for (Person person : people) {
            int totalExercises = countExercises(person);
            map.put(person, totalExercises);
        }

        Map<Person, Integer> copy = new LinkedHashMap<>(map);

        ArrayList<Person> leaderboard = buildLeaderboard(copy);

        int rank = 1;

        for (Person person : leaderboard) {
            System.out.println("****Leaderboard****");
            System.out.println(rank + ". " + person.getName() +
                    " completed " + map.get(person) + " exercises");
            rank++;
        }
    }
}