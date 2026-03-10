# Library Book Tracker
## The Mission

This project is an application that simulates a small library management system.

The goal of the project is to demonstrate our ability to:

* Design a real-world software system

* Structure a Java program using multiple classes

* Collaborate with a partner using Git and GitHub

* Explain the technical decisions behind our code

The application allows users to add books, view books, borrow books, return books, and search for books.

# Theme: Everyday Application

This project represents a real-world system that libraries use to track books and their availability.

The program helps users manage a collection of books by assigning each book a unique ID, making it easier to borrow and return books without typing the full title.

# Team Structure

This project was completed in pairs.

Using concepts from Scrum, we organized development into three sprint phases.

Each sprint represents a stage of the development process:

* Planning

* Building

* Reflecting

# Sprint Documentation
## Sprint 1 — The Plan
### Problem

Libraries need a simple way to track which books are available and which are borrowed.
This application provides a command line system that allows users to manage books in a small library.

### Planned Features

* Add books

* View all books

* Borrow books

* Return books

* Search for books

* Exit the program

### Planned Classes

* Book – represents individual books

* Library – manages the collection of books

* Main – handles the user interface and program flow

### Work Division

### William

* Designed the Book class

* Created the UML diagram

* Helped design the system structure

### Mesheik
* Built the CLI menu system

* Implemented input validation

* Managed user interaction

## Both of us

* Built and tested the Library class

* Implemented borrowing and returning logic

* Tested the full application

# Sprint 2 — The Build
## What We Implemented

The finished program allows users to:

* Add books to the system

* View all books

* View available books

* View borrowed books

* Borrow books using a Book ID

* Return books using a Book ID

* Search books by ID or title

### Changes From the Original Plan

During development we improved the system by:

* Adding a unique ID system for books

* Implementing input validation to prevent crashes

* Organizing the code into smaller helper methods for readability

### Challenges

Some challenges we faced included:

* Designing a system to generate unique book IDs

* Validating user input from the command line

* Organizing responsibilities between classes

### Solutions

We solved these challenges by:

* Using a nextBookId counter in the Library class

* Creating reusable input validation methods

* Separating logic between Book, Library, and Main

## Sprint 3 — The Reflection
### What Works Well

The program is organized and demonstrates strong use of object-oriented programming.

The Book ID system improves usability because users can borrow and return books without typing the exact title.

### Future Improvements

If we had more time, we would add:

* Removing books from the system

* Saving book data to files

* Book categories or genres

* Sorting and filtering options

### Java Concepts Used

This project demonstrates several key Java concepts:

* Classes and Objects

* Constructors

* Methods

* Encapsulation

* Loops

* Conditional statements

* Collections (ArrayList)

* User input using Scanner

### What We Learned

Through this project we learned how to:

* Design a Java application from scratch

* Organize code into multiple classes

* Collaborate using Git and GitHub

* Apply Java fundamentals to a real-world problem

## Code Explanation Requirement

Our code includes comments explaining technical decisions, such as:

* Why certain classes were created

* Why ArrayList was used to store books

* Why loops are used to iterate through book collections

* Why input validation methods were implemented


## Technical Expectations

This project demonstrates the following Java skills:

* Classes and Objects

* Constructors

* Methods

* Encapsulation (getters/setters)

* Loops

* Conditional statements

* Collections (ArrayList)

* User input using Scanner

* Clean program organization


Final Goal

This project demonstrates that we can:

* Design software without step-by-step instructions

* Apply Java concepts to solve a real problem

* Work collaboratively using Git and GitHub

* Explain our code and technical decisions

The project reinforces the Java concepts learned throughout the course and prepares us for the final Java assessment.

## Contributors

* Mesheik Brown

* William Blue