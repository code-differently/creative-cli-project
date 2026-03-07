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

        // Creates a new Person object and stores it in the users list
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
            System.out.println("4) Display all workouts");
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

                    // Adds workout to the user's workout list
                    ArrayList<Workout> workouts = person.getWorkouts();
                    workouts.add(workout);
                    person.setWorkouts(workouts);

                    // Marks this workout as the user's active workout
                    person.setActiveWorkout(workout);
                    break;

                // Displays leaderboard rankings
                case 2:
                    displayLeaderboard(getUsers());
                    break;

                // Opens user settings menu
                case 3:
                    displaySettings(person, sc);
                    break;

               // Displays all workouts the user has done
                case 4:
                    displayAllWorkouts(person);
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

                    // Confirms the current password matches
                    if (person.getPassword().equals(password)) {

                        // Prompts for new password twice
                        System.out.print("Enter your new password: ");
                        String pass1 = sc.nextLine();
                        System.out.print("Enter your new password again: ");
                        String pass2 = sc.nextLine();

                        // Ensures both new passwords match
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

    // Creates a workout and collects exercise information from the user
    public static Workout createWorkout(Scanner scanner) {

        System.out.println("Create New Workout");

        // Collects workout duration
        System.out.print("Enter workout duration: ");
        String duration = scanner.nextLine();

        // Records workout date automatically
        Date date = new Date();

        // Initializes workout object
        Workout workout = new Workout(duration);

        // Asks how many exercises to log
        System.out.print("How many exercises are in this workout? ");
        int exerciseCount = scanner.nextInt();
        scanner.nextLine();

        // Loops through and collects each exercise
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

        // Requests email from user
        String email = validateEmail(sc);

        // Requests password from user
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        // Searches through registered users
        for (Person user : FitnessApp.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        // Returns null if login fails
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
                // Validates email pattern
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

    // Displays all the workouts the user has done
    public static void displayAllWorkouts(Person person){
        // If there are no workouts completed display a message
        if (person.getWorkouts().size() ==0){
            System.out.println("No workouts have been completed");
        }

        // Cycles through the list of workouts to display the data of each workout
        for (Workout workout: person.getWorkouts()){
            workout.displayWorkoutInfo();
        }
    }

    // Finds the person with the highest value in the map
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

    // Counts total number of exercises completed by a person
    public static int countExercises(Person person) {
        int count = 0;

        for (Workout workout : person.getWorkouts()) {
            count += workout.getExercises().size();
        }

        return count;
    }

    // Counts total calories burned by a person across all workouts
    public static int countCaloriesBurned(Person person) {
        int count = 0;

        // Retrieves the user's workouts
        ArrayList<Workout> workouts = person.getWorkouts();

        for (Workout workout : workouts) {
            for (Exercise exercise : workout.getExercises()) {
                count += exercise.getCaloriesBurned();
            }
        }

        return count;
    }

    // Builds a sorted leaderboard from a map of people and scores
    public static ArrayList<Person> buildLeaderboard(Map<Person, Integer> map) {
        ArrayList<Person> leaderboard = new ArrayList<>();

        // Repeatedly finds the max value and removes it
        while (!map.isEmpty()) {
            Person maxPerson = getMaxKey(map);
            leaderboard.add(maxPerson);
            map.remove(maxPerson);
        }

        return leaderboard;
    }

    // Displays leaderboard ranked by total number of exercises
    public static void rankByTotalExercises(ArrayList<Person> people){

        // Stores people and their exercise totals
        Map<Person, Integer> map = new LinkedHashMap<>();

        for (Person person : people) {
            int totalExercises = countExercises(person);
            map.put(person, totalExercises);
        }

        // Copies map so original data is preserved
        Map<Person, Integer> copy = new LinkedHashMap<>(map);

        // Builds sorted leaderboard
        ArrayList<Person> leaderboard = buildLeaderboard(copy);

        int rank = 1;

        System.out.println("\n****Leaderboard****");
        System.out.println("Ranked by total amount of exercises: ");

        // Displays ranked results
        for (Person person : leaderboard) {
            System.out.println(rank + ". " + person.getName() +
                    " completed " + map.get(person) + " exercises");
            rank++;
        }
    }

    // Displays leaderboard ranked by total calories burned
    public static void rankByTotalCaloriesBurned(ArrayList<Person> people){

        // Stores people and their calorie totals
        Map<Person, Integer> map = new LinkedHashMap<>();

        for (Person person : people) {
            int totalCalories = countCaloriesBurned(person);
            map.put(person, totalCalories);
        }

        // Copies map so original data remains unchanged
        Map<Person, Integer> copy = new LinkedHashMap<>(map);

        // Builds sorted leaderboard
        ArrayList<Person> leaderboard = buildLeaderboard(copy);

        int rank = 1;

        System.out.println("\n****Leaderboard****");
        System.out.println("Ranked by total amount of calories burned: ");

        // Displays ranked results
        for (Person person : leaderboard) {
            System.out.println(rank + ". " + person.getName() +
                    " burned " + map.get(person) + " calories");
            rank++;
        }
    }

    // Displays both leaderboard rankings
    public static void displayLeaderboard(ArrayList<Person> people) {

        // Shows ranking by total exercises
        rankByTotalExercises(people);

        // Shows ranking by calories burned
        rankByTotalCaloriesBurned(people);
    }
}