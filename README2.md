# Java Chore Generator (CLI Project)

This project is a simple **Command Line Application written in Java** that randomly assigns chores from a list provided by the user and calculates a reward based on the number of tasks completed. The program demonstrates basic Java programming concepts such as user input, arrays, loops, conditionals, and random number generation.

---

# Sprint Documentation

## Sprint 1 — The Plan

### What problem the program solves
Many people struggle to decide which chores to do first or how to fairly assign chores among tasks. This program helps solve that problem by randomly generating chores from a list provided by the user. It also calculates a reward based on the number of tasks completed.

### Features planned
The program was designed with the following features:

- Allow users to enter multiple chores separated by commas
- Randomly select chores from the list
- Allow users to define a payment amount per task
- Add a bonus reward if more than one task is assigned
- Display the assigned tasks and the total reward

### Classes expected
The main class used in this program is:

- **TaskGenerator**
    - Contains the `main` method
    - Handles user input
    - Generates random tasks
    - Calculates rewards

Future improvements could separate responsibilities into additional classes such as:
- `TaskManager`
- `RewardCalculator`

### Work division
This project was developed collaboratively. Responsibilities were divided as follows:

- One partner focused on **program logic and calculations**
- One partner worked on **user input handling and random task generation**
- Both partners contributed to **testing, debugging, and documentation**

This planning stage acted as the **blueprint for building the program**.

---

## Sprint 2 — The Build

### What was actually implemented
The program successfully implements the following functionality:

1. Prompts the user to enter chores separated by commas
2. Converts the input string into an array of tasks
3. Asks the user to enter:
    - Base allowance per task
    - Bonus amount for completing multiple tasks
4. Randomly selects chores from the list
5. Displays the assigned tasks
6. Calculates the total reward
7. Displays a final reward summary

### What changed from the original plan
Originally we planned to allow unlimited dynamic tasks and store them using collections such as an `ArrayList`. During development, we simplified the implementation by storing the tasks in a **String array created from the split input**.

We also focused on building everything inside a **single class** to keep the program easier to understand.

### Challenges encountered
Some challenges during development included:

- Handling user input correctly
- Splitting the chore list into individual tasks
- Understanding how random number generation works
- Managing numeric calculations for rewards and bonuses
- Formatting output correctly using `printf`

### How those challenges were solved
These issues were solved by:

- Using the `Scanner` class to safely read user input
- Using the `split(",")` method to convert a string into an array
- Using the `Random` class to select tasks randomly
- Using conditional logic (`if` statements) to apply bonuses
- Using formatted printing (`printf`) to show currency values clearly

Through debugging and testing, the program was refined until it worked correctly.

---

## Sprint 3 — The Reflection

### What works well in the program
Several parts of the program work effectively:

- The random task generation makes the program interactive and dynamic
- The program accepts custom chores from the user
- Reward calculations are clearly displayed
- The command-line interface is simple and easy to use

### What could be improved with more time
If we had more time, we would improve the program by:

- Using an `ArrayList` instead of a simple array
- Preventing duplicate tasks from being assigned
- Allowing the program to run multiple rounds without restarting
- Creating separate classes for task management and reward calculations
- Adding better input validation

### Java concepts used the most
The main Java concepts used in this project include:

- Classes and the `main` method
- `Scanner` for user input
- Arrays for storing tasks
- The `Random` class for random task selection
- `for` loops to iterate through tasks
- Conditional statements (`if`)
- Variables and primitive data types (`int`, `double`, `String`)
- Formatted output using `System.out.printf`

### What was learned from the experience
This project helped reinforce several important programming concepts:

- Breaking a problem into smaller logical steps
- Using Java classes from the standard library
- Writing readable and well-commented code
- Debugging logical errors in loops and calculations
- Understanding how user input flows through a program

The project also demonstrated how planning, building, and reflecting in sprints can help organize the development process.

---

# Code Explanation

The code contains comments explaining technical decisions, including:

- Why the `Scanner` class is used to collect user input
- Why the `Random` class is used to randomly select tasks
- How arrays are used to store tasks entered by the user
- Why loops are used to display tasks
- Why conditional statements determine when bonuses apply

Welcome the TaskGenerator Command Line App!

