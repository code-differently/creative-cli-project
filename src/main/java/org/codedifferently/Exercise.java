package org.codedifferently;

// Class that represents a single exercise
public class Exercise {

    // The type of exercise (ex: cardio, strength, etc.)
    private ExerciseType type;

    // Name of the exercise (ex: Pushups, Running)
    private String name;

    // Number of calories burned during the exercise
    private int caloriesBurned;

    // Constructor used to create a new Exercise object
    public Exercise(ExerciseType type, String name, int caloriesBurned) {
        this.type = type;               // set exercise type
        this.name = name;               // set exercise name
        this.caloriesBurned = caloriesBurned; // set calories burned
    }

    // Returns the exercise type
    public ExerciseType getType() {
        return type;
    }

    // Updates the exercise type
    public void setType(ExerciseType type) {
        this.type = type;
    }

    // Returns the name of the exercise
    public String getName() {
        return name;
    }

    // Updates the name of the exercise
    public void setName(String name) {
        this.name = name;
    }

    // Returns the number of calories burned
    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    // Updates the number of calories burned
    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    // Displays the exercise information to the console
    public void displayExerciseInfo() {
        System.out.println("--------------------");
        System.out.println("Exercise Information");
        System.out.println("Name: " + name);                 // print exercise name
        System.out.println("Type: " + type);                 // print exercise type
        System.out.println("Calories Burned: " + caloriesBurned); // print calories burned
        System.out.println();
    }
}