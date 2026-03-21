# Group Differently
## The Mission

Group Differently is a **Java command-line application** designed to help organize students into groups efficiently.

The goal of this program is to simulate a real-world classroom scenario where instructors or organizers need to:

- Create and manage students
- Create groups
- Assign students to groups
- Shuffle students across groups
- Move students between groups when adjustments are needed

Instead of manually organizing groups, this application allows users to manage and restructure teams quickly using simple command-line controls.

This project demonstrates our ability to:

* Design software systems
* Structure Java programs effectively
* Apply object-oriented programming concepts
* Collaborate with a partner using Agile principles
* Explain our technical decisions through documentation and comments

---

# Theme: Everyday Application

Group Differently represents a **real-world system used in classrooms, training programs, and team-based environments**.

Teachers, instructors, or team leaders often need to divide people into balanced groups. This application simplifies that process by allowing users to organize and shuffle group assignments automatically while still allowing manual adjustments when necessary.

---

# Team Structure

This project was developed **in pairs**.

Using our **Certified Scrum Master knowledge**, we organized development into **three sprint phases**.

Each sprint allowed us to progressively design, implement, and evaluate our system.

---

# Sprint Documentation

---

## Sprint 1 — The Plan

Before writing code, we planned the structure of the system.

### Problem the Program Solves

Instructors often need to divide students into groups for:

- Projects
- Discussions
- Lab assignments
- Team activities

Manually organizing groups can be time-consuming, especially when groups must be balanced or frequently adjusted.

Group Differently provides a simple system for managing students and distributing them into groups automatically or manually.

### Planned Features

We planned the following core features:

1. Add Student
2. Add Group
3. View Groups and Students
4. Move students from one group to another
5. Remove a student from a group
6. Shuffle students into groups based on a preferred team size
7. Exit the program

### Expected Classes

We expected to create several classes to organize the program:

**Student**

Stores student information including:

- ID
- First name
- Last name
- Email
- Age
- GPA

**Group**

Represents a group with:

- Group ID
- Group name
- A list of students assigned to the group

**Main / Application Class**

Handles:

- User input
- Menu navigation
- Program execution

**Manager / Controller Class (optional)**

Responsible for managing collections of students and groups.

### Work Division

Our team divided the work so both partners contributed to different parts of the system, including:

- Designing the data structures
- Implementing student and group classes
- Implementing menu functionality
- Implementing shuffle and group management logic
- Testing program behavior

---

## Sprint 2 — The Build

During this phase we implemented the core functionality of the program.

### Implemented Features

The final program allows users to:

1. **Add Student**

Users can create students with:

- ID
- First Name
- Last Name
- Email
- Age
- GPA

2. **Add Group**

Users can create groups with:

- Group ID
- Group name

3. **View Groups and Students**

Users can display all groups and the students assigned to them.

4. **Move Student Between Groups**

Students can be transferred from one group to another using their **Student ID**.

5. **Remove Student From Group**

Students can be removed from a group if they need to be reassigned.

6. **Shuffle Groups**

The shuffle feature allows users to enter a **preferred team size**.  
The program distributes students across available groups while trying to keep the groups balanced.

7. **Exit Program**

Allows the user to safely terminate the application.

### Program Menu

When the program starts, the user sees a command-line menu:


### Challenges Encountered

Some challenges included:

- Designing a system to efficiently search students and groups
- Ensuring groups remained balanced during shuffling
- Managing relationships between students and groups
- Handling user input safely in the command line

### Solutions

To solve these challenges we:

- Used **IDs for students and groups** to simplify searching
- Used **collections such as ArrayList** to store dynamic lists of students and groups
- Built methods that handle student movement and group assignment cleanly

---

## Sprint 3 — The Reflection

### What Works Well

The program successfully allows users to:

- Manage students and groups
- Automatically distribute students across groups
- Adjust group assignments manually
- View organized group information easily

The menu system provides a simple interface for interacting with the program.

### Improvements With More Time

If we had more time, we would improve the program by adding:

- Data persistence (saving students and groups to files)
- A graphical user interface (GUI)
- More advanced shuffle algorithms
- GPA-based or skill-based group balancing
- Editing or updating student information

### Java Concepts Used

This project heavily utilized several core Java concepts:

- **Classes and Objects**
- **Constructors**
- **Encapsulation with getters and setters**
- **Collections (ArrayList)**
- **Loops**
- **Conditional statements**
- **User input with Scanner**
- **Method organization and modular design**

### What We Learned

This project helped us better understand:

- How to design object-oriented programs
- How to manage relationships between objects
- How to structure larger Java programs
- How to document and explain software design decisions

---