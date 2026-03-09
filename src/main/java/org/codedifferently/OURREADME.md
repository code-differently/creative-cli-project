# Money Bucks Coffee Shop Rewards System

## Project Overview
The **Money Bucks Coffee Shop Rewards System** is a Java Command Line Interface (CLI) application designed to simulate a coffee shop rewards program.

The goal of this project is to demonstrate understanding of:

- Java fundamentals
- Object-Oriented Programming (OOP)
- Program design
- Agile/Scrum sprint development

The system allows users to order drinks and food items, track purchases, earn rewards, and view receipts while the program records basic sales metrics.

---

# Sprint 1 — Planning

## Problem the Program Solves
Coffee shops often use **reward systems** to encourage repeat customers.

This program simulates that process by allowing users to:

- Order drinks and food
- Earn progress toward free rewards
- Track purchases
- Monitor daily sales activity

The system calculates rewards and maintains simple sales data.

---

## Planned Features

- Command-line ordering menu
- Customer rewards tracking (free drink after a set number of purchases)
- Daily sales tracking
- Ability to join a rewards program
- Receipt display showing purchase totals and reward progress

---

## Planned Classes

### Main
Controls the application flow and user interaction.

### Menu
Stores menu items using four `ArrayList` collections.

### Receipt
Generates a Starbucks-style receipt displaying order details.

### Coffee
Represents a menu item including:
- Name
- Price
- Item type (drink or food)

### Customer
Stores rewards member information and drink purchase count.

### Sales
Tracks business metrics such as:
- Total revenue
- Number of drinks sold
- Customers served

---

## Teamwork
The team collaborated to:

- Create the sprint plan
- Design the program structure
- Implement code across each class

---

# Sprint 2 — Development

## Features Implemented

- Menu system using drink and food item objects
- Customer rewards logic using methods such as:
    - `addDrink()`
    - `rewardsEligible()`
- Sales tracking including:
    - Total revenue
    - Drinks sold
    - Customers served
- Interactive CLI menu allowing users to order multiple items
- Receipt generation for a realistic coffee shop experience

---

## Changes From the Original Plan

- Added additional `ArrayList` collections
- Improved code organization and structure

---

## Challenges Encountered

- Integrating previous code without causing program crashes
- Connecting reward logic with menu purchase functionality

---

## Solutions

- Verified that methods being called matched their implementations
- Ran the program frequently during development to detect errors early

---

# Sprint 3 — Reflection

## What Worked Well

- Separating classes based on clear responsibilities
- Implementing a rewards system that tracks purchases and assigns members to tier levels

---

## Areas for Improvement

Future improvements could include:

- Allowing users to order multiple items simultaneously
- Making the tab key visible during input
- Allowing deletion during input to correct mistakes
- Remembering the tier level of returning members

---

# Java Concepts Used

This project heavily utilized core Java concepts:

- Object-Oriented Programming (classes and objects)
- Constructors for initializing objects
- Encapsulation using getters and setters
- Loops and conditional statements
- Collections (`ArrayList`) for managing groups of data

---

# What We Learned

This project demonstrated how multiple Java concepts work together within a complete application.

Planning the structure before coding made the development process smoother and helped prevent errors. The project also reinforced the importance of **Scrum development practices**.

In real-world software development, inadequate planning and insufficient testing can have serious consequences. Even a small programming error could expose customer information or create system vulnerabilities, potentially leading to legal and financial issues.