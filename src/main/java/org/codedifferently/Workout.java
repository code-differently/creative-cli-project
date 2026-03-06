package org.codedifferently;

import java.util.ArrayList;
import java.util.Date;

public class Workout {
    private String duration;
    private Date date;
    private boolean completed;
    private ArrayList<Exercise> exercises;

    public Workout(String duration, Date date, boolean completed, ArrayList<Exercise> exercises) {
        this.duration = duration;
        this.date = date;
        this.completed = completed;
        this.exercises = new ArrayList<>();
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    public void displayWorkoutInfo(){

    }

}
