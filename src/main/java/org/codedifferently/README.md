# Consultant Weekly Management System

## Overview

The **Consultant Weekly Management System** is a Java-based desktop application designed to help manage customer appointments for a consultant business.

This system provides a **Graphical User Interface (GUI)** built using **Java Swing**, allowing users to manage customers, schedule appointments, track waitlists, and view weekly calendars.

The program helps consultants organize their weekly schedule, track customer check-ins, and manage appointment availability efficiently.

---

# Technologies Used

- Java
- Java Swing (GUI)
- Object-Oriented Programming (OOP)
- Serialization for data persistence
- Collections (ArrayList, HashMap)
- Date and Time API (`LocalDateTime`, `LocalDate`, `LocalTime`)

---

# Project Structure

The project contains the following classes:

| Class | Description |
|------|-------------|
| `ConsultantWeeklyGUI.java` | Main GUI interface and application entry point |
| `ManagementSystem.java` | Core logic for managing customers, appointments, and waitlists |
| `Customer.java` | Represents a customer in the system |
| `Appointment.java` | Represents a scheduled appointment |

---

# Application Features

## Customer Management

The system allows users to:

- Add new customers
- Search for customers by ID or name
- View all registered customers
- Check-in customers

Each customer is assigned a **unique ID** automatically when created.

Example Customer Output:

```
Customer ID: A12345, Name: Alice, Checked-in: true
```

---

# Appointment Scheduling

The application includes a **weekly calendar interface** where appointments can be scheduled.

Features include:

- Schedule appointments in **30-minute time slots**
- Prevent double-booking
- Join a waitlist if a slot is already booked
- Cancel appointments
- Complete appointments

Appointments are stored in an **ArrayList**, while waitlists are stored using a **HashMap**.

---

# Weekly Calendar System

The calendar displays a **7-day schedule** starting from the current date.

### Working Hours
```
9:00 AM – 5:00 PM
```

### Slot Duration
```
30 minutes
```

### Slot Color Indicators

| Color | Meaning |
|------|--------|
| Green | Available |
| Red | Booked |
| Orange | Booked with waitlist |
| Yellow Border | Current time slot |

Users can interact with each slot using:

- **Left-click** → Schedule appointment
- **Right-click menu** →
    - Schedule / Join Waitlist
    - Complete Appointment
    - Cancel Appointment

---

# Waitlist System

If a time slot is already booked, customers may join the **waitlist**.

When an appointment is:

- **Completed**
- **Canceled**

The system automatically **promotes the next customer from the waitlist** into the available appointment slot.

---

# Daily Report Feature

The system can generate a **daily report** showing:

- Total appointments scheduled today
- Total appointments completed today

This helps track daily consultant activity.

Example Output:

```
--- Daily Report ---
Appointments Today: 6
Completed Today: 4
```

---

# Data Persistence

The system uses **Java Serialization** to save application data.

Saved data includes:

- Customers
- Appointments
- Waitlists

Data is stored in:

```
managementdata.ser
```

When the program starts, it attempts to **load existing data automatically**.

---

# User Interface

The GUI includes the following controls:

### Top Menu Buttons

- Add Customer
- Search Customer
- Check-In Customer
- Save Data
- Daily Report
- View Schedule
- View All Customers

### Calendar View

A scrollable weekly calendar where each time slot is represented as a button.

### Output Panel

A text area on the right side displays:

- System messages
- Customer information
- Reports
- Appointment status updates

---

# How to Run the Application

## Compile the Program

```
javac org/codedifferently/*.java
```

## Run the Program

```
java org.codedifferently.ConsultantWeeklyGUI
```

---

# Sprint Documentation

Because the development team recently earned their **Certified Scrum Master certification**, development was organized into three sprint phases.

---

# Sprint 1 — The Plan

## Problem Statement

Consultants need a simple system to organize weekly appointments, track customers, and manage scheduling conflicts.

Without a digital system, managing schedules manually can lead to:

- Double-booked appointments
- Lost customer records
- Poor organization of daily schedules

The goal was to create a **Java-based appointment management system** that solves these problems.

---

## Planned Features

The following features were planned:

### Customer Features
- Add new customers
- Generate unique IDs
- Search customers
- Check-in customers

### Appointment Features
- Schedule appointments
- Prevent double-booking
- Cancel appointments
- Track appointment completion

### Scheduling System
- Weekly calendar
- 30-minute time slots
- Working hours (9 AM – 5 PM)

### Reporting
- Daily appointment summary
- Completed appointment tracking

---

## Planned Classes

- `Customer`
- `Appointment`
- `ManagementSystem`
- `ConsultantWeeklyGUI`

Each class was designed to follow **object-oriented programming principles**.

---

# Sprint 2 — The Build

## Implemented Features

The following features were successfully implemented:

- Java Swing GUI interface
- Weekly calendar scheduling system
- Appointment management
- Waitlist functionality
- Customer management system
- Daily report generation
- Data persistence using serialization

---

## Challenges Encountered

### GUI Layout Management

Designing the weekly calendar grid required careful layout planning.

Solution:
```
GridLayout was used to organize the calendar slots.
```

---

### Preventing Double Booking

Ensuring that no two appointments could occupy the same slot required additional validation.

Solution:

The system checks existing appointments before allowing scheduling.

---

### Waitlist Promotion

Handling waitlist promotion required tracking multiple customers for the same slot.

Solution:

A `HashMap<LocalDateTime, ArrayList<String>>` was used to store waitlists for each slot.

---

# Sprint 3 — The Reflection

## What Works Well

The application successfully provides:

- A functional GUI calendar
- Appointment scheduling
- Waitlist management
- Customer tracking
- Data persistence

The object-oriented structure also makes the program easy to extend.

---

## Possible Improvements

With more time, the system could be improved by adding:

- Database storage instead of serialization
- Email or SMS reminders
- Multiple consultants
- Advanced search filters
- Improved GUI styling

---

## Java Concepts Used

This project demonstrates the use of:

- Classes and Objects
- Inheritance and encapsulation
- ArrayLists
- HashMaps
- Event handling
- GUI programming with Swing
- Serialization
- Date and time APIs

---

## Lessons Learned

This project provided experience in:

- Designing a multi-class Java application
- Building graphical user interfaces
- Implementing real-world scheduling logic
- Managing program state and data persistence
- Applying Agile development through sprint planning

---

# Authors

Lan  
Amani