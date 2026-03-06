package org.codedifferently;

import java.util.ArrayList;

// Represents a user of the fitness application
public class Person {

    // Stores the person's name
    private String name;

    // Stores the person's email used for identification/login
    private String email;

    // Stores the person's password for authentication
    private String password;

    // Tracks the workout the user is currently performing (null if none)
    private Workout activeWorkout = null;

    // Stores all workouts associated with this user using a dynamic list
    private ArrayList<Workout> workouts;

    // Constructor initializes user information and an empty workout list
    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.workouts = new ArrayList<>();
    }

    // Returns the person's name
    public String getName() {
        return name;
    }

    // Updates the person's name
    public void setName(String name) {
        this.name = name;
    }

    // Returns the person's email
    public String getEmail() {
        return email;
    }

    // Updates the person's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns the list of workouts associated with the user
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    // Replaces the user's workout list
    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    // Returns the user's password
    public String getPassword() {
        return password;
    }

    // Updates the user's password
    public void setPassword(String password) {
        this.password = password;
    }

    // Returns the workout currently being performed
    public Workout getActiveWorkout() {
        return activeWorkout;
    }

    // Sets the user's current active workout
    public void setActiveWorkout(Workout activeWorkout) {
        this.activeWorkout = activeWorkout;
    }
}