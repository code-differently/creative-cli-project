package org.codedifferently;

public class Exercise {
    private ExerciseType type;
    private String name;
    private int caloriesBurned;

    public Exercise(ExerciseType type, String name, int caloriesBurned) {
        this.type = type;
        this.name = name;
        this.caloriesBurned = caloriesBurned;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
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

    public void displayExerciseInfo() {
        System.out.println("Exercise Information");
        System.out.println("--------------------");
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Calories Burned: " + caloriesBurned);
        System.out.println();
    }
}
