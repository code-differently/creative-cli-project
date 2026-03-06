package org.codedifferently;

import java.util.ArrayList;
import java.util.Date;

public class Workout {
    private String duration;
    private Date date;
    private ArrayList<Exercise> exercises;

    public Workout(String duration, Date date) {
        this.duration = duration;
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    public void displayWorkoutInfo(){
            System.out.println("******************************");
            System.out.println("\nWorkout Date " + date);
            System.out.println("Duration: " + duration);

            for (Exercise exercise : exercises) {
                System.out.println(exercise);
        }
            System.out.println("******************************");
    }

}
