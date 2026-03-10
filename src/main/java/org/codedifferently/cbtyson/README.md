# Group Differently

Group Differently is a simple application for organizing students into groups and managing team assignments efficiently. The program allows users to create students and groups, assign students to groups, shuffle group assignments based on preferred team sizes, and move students between groups when adjustments are needed.

This tool is designed for scenarios such as classroom team assignments, project group organization, or any situation where students need to be distributed across groups in a flexible way.

---

## Features

The application provides the following core functionality:

1. **Add Student**  
   Create a new student with the following attributes:
    - Student ID
    - First Name
    - Last Name
    - Email
    - Age
    - GPA

2. **Add Group**  
   Create a group with:
    - Group ID
    - Group Name

3. **View Groups and Students**  
   View all groups along with the students currently assigned to them.

4. **Move Students Between Groups**  
   Transfer a student from one group to another using their Student ID and Group ID.

5. **Remove Student From Group**  
   Remove a student from their current group assignment.

6. **Shuffle Groups by Team Size**  
   Automatically distribute all students into groups based on a **user-defined team size**.  
   The program attempts to balance groups as evenly as possible while respecting the preferred team size.

7. **Exit Program**  
   Safely close the application.

---

## Data Structure

### Student

Each student contains the following information:

| Field | Description |
|------|-------------|
| ID | Unique identifier for the student |
| First Name | Student's first name |
| Last Name | Student's last name |
| Email | Contact email |
| Age | Student age |
| GPA | Student grade point average |

### Group

Each group contains:

| Field | Description |
|------|-------------|
| ID | Unique identifier for the group |
| Name | Name of the group |

Group and student **IDs are used as the primary lookup mechanism** throughout the program for searching, assigning, and moving records.

---

## Program Workflow

When the application starts, the user is presented with a menu of available actions.
