# Property Management Resident System

A Java command-line application designed to help manage resident service requests in an apartment or housing complex. The system allows residents to submit service requests while management can track and organize them.

---

## Sprint 1 — The Plan

Our project is a **Property Management Resident System**, a Java application designed to help manage resident service requests in an apartment or housing complex. The goal of the program is to simulate a real property management system where residents can submit requests and management can track them.

The program helps organize common resident needs such as **maintenance requests, cleaning requests, and resident account information** in one system instead of handling them manually.

### Planned Features
- Creating and storing resident accounts
- Submitting maintenance requests
- Submitting cleaning requests
- Organizing services using an abstract `Service` class
- Displaying request details through a command-line interface

### Planned Classes
- `ResidentAccount`
- `MaintenanceRequest`
- `CleaningRequest`
- `Service` (abstract class)

### Work Distribution
We divided the work based on our strengths and previous experience. We also reused and adapted code from earlier projects to help build the system more efficiently.

- **Corey**: Documented the sprint phases and built the `MaintenanceRequest` class.
- **Derwin**: Developed the `ResidentAccount`, `CleaningRequest`, and `Service` classes and worked on integrating the overall functionality.

---

## Sprint 2 — The Build

During this sprint, we built the foundation of the **Property Management Resident System** by combining and refactoring code from previous projects. We implemented the main class structure including `MaintenanceRequest`, `CleaningRequest`, `ResidentAccount`, and the abstract `Service` class. This structure helped organize the system so resident information and service requests are handled separately.

Some parts of the project changed from our original plan. Instead of building everything from scratch, we reused and modified older code to fit the new system. This allowed us to focus more on integrating the classes and applying object-oriented design.

One challenge was making code from different projects work together consistently. We had to adjust class structures, naming conventions, and logic so everything fit into one cohesive system. We addressed this by reviewing each class, identifying shared behaviors, and using inheritance through the `Service` abstract class to organize the program more effectively.

---

## Sprint 3 — The Reflection

One thing that works well in our program is the way it models a real property management system using separate classes with clear responsibilities. The `ResidentAccount` class manages resident information, while `MaintenanceRequest` and `CleaningRequest` handle different types of service requests. The abstract `Service` class helps organize shared behavior between request types.

If we had more time, we would improve the system by adding features such as a better way to catch user input and stronger connections between residents and their service requests. We could also expand the command-line interface to make the program more interactive.

Throughout this project, we used several Java concepts including **classes and objects, inheritance, abstract classes, constructors, and encapsulation**. This experience helped us better understand how to design and organize a larger program while applying object-oriented programming principles.