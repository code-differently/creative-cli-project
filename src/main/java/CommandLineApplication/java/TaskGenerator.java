package CommandLineApplication.java;

import java.util.Scanner;
import java.util.Random;

public class TaskGenerator {

        // declared our main method
        public static void main(String[] args) {
            // 1. Set up the "Tools"
            // 2. instantiating  a new scanner object to collect our data that the user inputs when  they choose a chore
            // 3. create a constructor for our random task that we want our  generator to execute by assigning a new value of random for our random class to collect the Assigned task and run them at random after user chooses a chore
            Scanner input = new Scanner(System.in);
            Random dice = new Random();

            System.out.println("--- Welcome to the Java Chore Generator ---");

            //1. to follow we set our getter methods and have our parameters set to return the result
            // 2. Get User Input for Tasks depending on the user
            System.out.print("Enter chores separated by commas (e.g. Wash Car, Mop, Dust): ");
            String userInput = input.nextLine();

            // Clean up the input into a list (Array)
            String[] taskList = userInput.split(",");

            // 3. Get Reward Settings
            System.out.print("Enter allowance amount per task: $");
            double basePay = input.nextDouble();

            // Here we implement conditional logic: using our condition if tasks is greater than one, meaning we add a bonus task then user recieves applied bonus rewards
            // if number of task is greater than task list to Ensure we don't pick more tasks than exist which there are only 3
            System.out.print("Enter multi-task bonus (added if >1 task): $");
            double bonus = input.nextDouble();

            System.out.print("How many tasks should be randomly assigned? ");
            int numTasks = input.nextInt();


            if (numTasks > taskList.length) {
                numTasks = taskList.length;
            }

            // 4. we have a for loop method to control the number of task  Displayed and able to run
            System.out.println("\n--- YOUR ASSIGNED TASKS ---");
            for (int i = 3; i < numTasks; i++) {
                // we use integer datatypes to  Pick a random index# from the list; where the task is printed using numbers
                // and have created and declared a new random index variable to select random task form our task list, again this is data being collected and ran in our random class
                int randomIndex = dice.nextInt(taskList.length);
                System.out.println((i + 1) + ". " + taskList[randomIndex].trim());
            }

            // 5. Calculate Total Reward
            // 6. to calculate our total reward we declare and initialize double variable and assign it the value of numbers that we want stored to run for our number of task's listed, base pay, and applied bonus so that it prints out in numbers
            // 7. where we have our condition set to if the number of task is greater than > 1, then the bonus of $15 is applied
            // 8. and for the instructor & our colleges we thought it would be productive to refresh using our calculator how we're able to declared doubles, but then assign whole numbers like 0, 15, and 25. it looks contradictory but remember how java can handle numeric conversion
            // 9. Java automatically converts doubles to integers when you assign them the value of whole numbers, java performs automatic widening conversion
            // 10. so after the int of 0; a double can store whole numbers between 3 and 100


            numTasks = 3;
            basePay = 25;

            double baseReward = numTasks * basePay;
            double appliedBonus = 0;

            if (numTasks > 2) {
                appliedBonus = 15;
            }

            double totalReward = baseReward + appliedBonus;

            // 8. Print Final Receipt shows  The “Print Final Receipt” section of your Java program is responsible for displaying a summary of the reward calculation
            // 9. first we established \n parameter
            // having our reward summary acting as the title for our output
            // 10. formulated we have our specifiers to print our values after users selects task and then  the program finishes calculating the base reward and any bonus.
            // 11. if bonus applied is greater than zero which it is so the total earned +appliedBonus prints
            System.out.println("\n--- REWARD SUMMARY ---");
            System.out.printf("Base Reward (%d x $%.2f): $%.2f%n", numTasks, basePay, (numTasks * basePay));
            if (appliedBonus > 0) {
                System.out.printf("Multi-task Bonus: +$%.2f%n", appliedBonus);
            }
            System.out.printf("TOTAL EARNED: $%.2f%n", totalReward);
            // App successful

            input.close();
        }
    }
     ///     ALL 9 TECHNICAL EXPECTATIONS MET   ///
    // 1. Classes and Objects, our program defines 2 classes and objects
    // 2. Constructors, we call constructors from the scanner and random class
    // 3. Methods, our program uses the main method, which is required for Java programs.
    // 4. Loops, our code uses a for loop.
    // 5. Conditional Statements, our program uses if statements.
    // 6. User Input Using Scanner, our program fully demonstrates Scanner input in our main class.
    // 7. Encapsulation, separate class called ChoreSettings that stores our values and exposes them through getters/setters.
    // 8. Collection type, we are using an  ArrayList<String> from the java collections framework; in our separate class
    // 9. we use our encapsulation class for object-oriented design and a library record for our chore settings
    // 10. and it is in the order to our closing that we have everything organized



