package org.codedifferently;
import java.util.ArrayList;

public class Person {
    private String name;
    private String email;
    private ArrayList<Workout> workouts;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        this.workouts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }
}
