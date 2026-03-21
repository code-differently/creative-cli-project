# ☕ Money Bucks Coffee Shop Rewards System

## Project Overview
The **Money Bucks Coffee Shop Rewards System** is a Java command-line application that simulates a coffee shop ordering and rewards program.

The goal of this project is to demonstrate understanding of:

- Java fundamentals
- Object-Oriented Programming
- Program structure and design
- Team collaboration through a sprint development process

The application allows users to place orders, track rewards progress, and view receipts while the system tracks sales metrics for the business.

---

# Sprint 1 — Planning

## Problem the Program Solves
Many coffee shops use reward systems to encourage repeat customers.  
This program simulates that concept by allowing users to:

- Order drinks and food
- Earn progress toward free rewards
- Track purchases
- Generate receipts
- Record daily sales statistics

---

## Key Features Planned

- Command-line menu ordering system
- Customer rewards tracking (free drink after a set number of purchases)
- Daily sales tracking
- Ability to join the rewards program
- Receipt display showing totals and reward progress

---

## Expected Classes

### Main
Controls the application flow and user interaction.

### Menu
Stores all menu items in multiple `ArrayList` collections.

### Coffee
Represents a menu item including price and drink/food type.

### Customer
Stores rewards member information and drink purchase count.

### Receipt
Generates a Starbucks-style receipt for orders.

### Sales
Tracks business metrics such as:

- Revenue
- Drinks sold
- Customers served

---

## Teamwork
The team collaborated to:

- Design the sprint plan
- Structure the classes
- Implement program functionality
- Test and debug the application

---

# Sprint 2 — Development

## What Was Implemented

- Menu system using drink and food item objects
- Customer rewards logic using methods like `addDrink()` and `rewardsEligible()`
- Sales tracking with totals for:
    - Revenue
    - Drinks sold
    - Customers served
- Interactive CLI menu allowing users to order multiple items
- Receipt class to create a a Starbucks-style ordering experience

---

## Changes From the Original Plan

- Added additional `ArrayList` collections to better organize menu items
- Cleaned and refactored sections of the code for better readability

---

## Challenges Encountered

- Integrating previously written code without crashing the program
- Connecting reward logic with menu purchases
- Managing program flow during user input

---

## Solutions

- Verified that all method calls matched their implementations
- Tested the program frequently while coding to catch errors early
- Refactored code when necessary to resolve issues

---

# Sprint 3 — Reflection

## What Works Well

- Separating classes based on specific responsibilities
- A rewards system that tracks purchases and assigns members to tiers

---

## Improvements for the Future

- Allow ordering multiple items at once more efficiently
- Improve input visibility while typing
- Add the ability to delete or edit input mistakes
- Save and remember a member's reward tier between sessions

---

## Java Concepts Used

This project heavily utilized the following Java concepts:

- Object-Oriented Programming (OOP)
- Classes and Objects
- Constructors
- Encapsulation using getters and setters
- Loops and conditionals for program control
- Collections (`ArrayList`) for managing data

---

## What We Learned

This project reinforced how multiple Java concepts work together to build a complete application.

Planning the program structure before writing code helped simplify development and reduce errors. We also learned how **Scrum-style sprint planning** helps organize software development.

In real-world applications, inadequate planning and insufficient testing can have serious consequences. Even a small software error could lead to major issues such as data breaches or loss of customer information.

---

## How to Run the Program

1. Clone or download the repository
2. Open the project in **IntelliJ IDEA**
3. Run the `Main` class
4. Follow the command-line prompts to place an order