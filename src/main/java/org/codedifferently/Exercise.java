package org.codedifferently;

public class Exercise {
    private WorkoutType type;
    private String name;
    private int caloriesBurned;

    public Exercise(WorkoutType type, String name, int caloriesBurned) {
        this.type = type;
        this.name = name;
        this.caloriesBurned = caloriesBurned;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
}
