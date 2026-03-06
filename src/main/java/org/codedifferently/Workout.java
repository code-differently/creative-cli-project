package org.codedifferently;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Workout class represents a workout session.
 * It stores information about the workout duration, date,
 * completion status, and the exercises performed.
 */
public class Workout {

    // Length of the workout (ex: "45 minutes")
    private String duration;

    // Date the workout occurred
    private Date date;

    // Indicates whether the workout has been completed
    private boolean completed;

    // List of exercises included in the workout
    private ArrayList<Exercise> exercises;

    public Workout(String duration, Date date, boolean completed) {
        this.duration = duration;
        this.date = date;
        this.completed = completed;

        // Initialize the exercises list
        this.exercises = new ArrayList<>();
    }

    /**
     * Gets the workout duration
     * @return duration of the workout
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the workout duration
     * @param duration new workout duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the date of the workout
     * @return workout date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the workout
     * @param date new workout date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Checks if the workout is completed
     * @return true if completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the workout completion status
     * @param completed completion status
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Gets the list of exercises in the workout
     * @return list of exercises
     */
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    /**
     * Adds a new exercise to the workout
     * @param exercise exercise to be added
     */
    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    /**
     * Displays detailed information about the workout
     * including its exercises.
     */
    public void displayWorkoutInfo(){
        System.out.println("******************************");
        System.out.println("\nWorkout Date: " + date);
        System.out.println("Duration: " + duration);
        System.out.println("Status: " + completed);

        // Loop through each exercise and print it
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }

        System.out.println("******************************");
    }

}