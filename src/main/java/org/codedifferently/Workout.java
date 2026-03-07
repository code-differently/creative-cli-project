package org.codedifferently;

import java.util.ArrayList;
import java.util.Date;

// Class that represents a workout session
public class Workout {

    // How long the workout lasted (ex: "30 minutes")
    private String duration;

    // List that stores all exercises done in this workout
    private ArrayList<Exercise> exercises;

    // Constructor used to create a new Workout object
    public Workout(String duration) {
        this.duration = duration;   // set workout duration
        exercises = new ArrayList<>(); // create an empty list of exercises
    }

    // Returns the workout duration
    public String getDuration() {
        return duration;
    }

    // Updates the workout duration
    public void setDuration(String duration) {
        this.duration = duration;
    }

    // Returns the list of exercises in this workout
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    // Adds a new exercise to the workout
    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    // Displays the workout information and all exercises in it
    public void displayWorkoutInfo(){

        System.out.println("******************************");

        // Print workout duration
        System.out.println("Duration: " + duration);

        // Loop through all exercises and print them
        for (Exercise exercise : exercises) {
            exercise.displayExerciseInfo();
        }

        System.out.println("******************************");
    }

}