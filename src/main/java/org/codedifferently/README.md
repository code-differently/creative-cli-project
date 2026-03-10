# Sprint Documentation

## Sprint 1 — The Plan
Our project was originally designed to be a real-time workout tracking application that would allow users to track their exercises as they performed them. The goal was to help individuals monitor their workouts live, organize their routines, and keep track of their physical activity as it happened.
To support this functionality, we planned several core features. 

Users would be able to create workouts, add exercises to those workouts, and track their progress in real time. Exercises would be categorized using an enumeration to organize different types of workouts and improve the structure of the application.
The program was designed to include several main classes: FitnessApplication, Exercise, Person, and Workout. Each class represents a different part of the system, helping to organize user data, exercises, and workout sessions. Additionally, an ExerciseType enumeration was created to represent different categories of exercises.

Work for this sprint was divided between both team members. Jayden implemented the Person class, FitnessApplication menu system and created the ExerciseType enumeration. Bryant implemented the Exercise, and Workout classes.

## Sprint 2 - The Build
Sprint 2 — The Build

During this sprint, we implemented the core structure of the fitness application. The program allows users to log workouts through a menu-based interface where they can create workout entries and associate exercises with them. Key classes such as FitnessApplication, Exercise, Person, and Workout were developed, along with the ExerciseType enumeration to categorize exercises.

One major change from our original plan was shifting from a real-time workout tracker to a workout logging application. The initial concept required features like timers and more complex state management. Due to time constraints, we simplified the scope so users could log workouts after completing them rather than track them live.

The main challenge was attempting to implement the more complex tracking functionality within the limited sprint timeframe. After recognizing that it would require significantly more time and testing, we adjusted the project scope and focused on building a reliable workout logger.

By narrowing the scope, we were able to complete a functional application while still achieving the core goal of helping users organize and record workouts. This adjustment reflects a common reality in software development, where project plans often evolve to ensure a working product is delivered within constraints.

## Sprint 3 — The Reflection
Several aspects of our program work well. The code is well organized and not overly complicated, with logic divided into multiple functions to keep responsibilities clear and manageable. The application also handles different types of user input without crashing, which helps maintain stability during use.

With more time, we would improve the leaderboard system. Currently, it only ranks user progress in two ways, but we would expand it to include additional metrics to provide a more detailed view of user performance.

The Java concepts we used most frequently were encapsulation, conditionals, and loops. Conditionals and loops were especially important for building the menu system and iterating through collections to manage workouts and exercises.

One major takeaway from this project was the importance of coordination and communication when working in a team. Creating a clear plan before coding helped keep everyone aligned and reduced misunderstandings. We also learned that tools like diagrams are helpful for outlining the structure of a program before implementation. 

Overall, this experience helped us better understand both collaborative development and practical Java programming.