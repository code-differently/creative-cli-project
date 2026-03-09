package CommandLineApplication.java;


import java.util.ArrayList;


// Encapsulated class using Collections
public class ChoreSettings {

    // Collection instead of array
    private ArrayList<String> taskList = new ArrayList<>();
    private double basePay;
    private double bonus;
    private int numTasks;

    // Getter for task list
    public ArrayList<String> getTaskList() {
        return taskList;
    }

    // Setter for task list
    public void setTaskList(ArrayList<String> taskList) {
        this.taskList = taskList;
    }

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }
}

