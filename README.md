# Employee Management System

A Java console application for basic employee tracking. The program allows users to log in by ID, review employee hours, update hours, add new hires, and view all employee summaries.

## Sprint 1 - The Plan

### Problem the Program Solves
Small teams often need a simple way to track employee records and work hours without a full database or web app. This project solves that by providing a lightweight command-line system for employee management tasks.

### Planned Features
- ID-based login flow
- Menu-driven actions for managers/employees
- View an employee's current hours
- Update employee hours
- Add a new employee with a random 3-digit ID
- Print a list of all employees

### Planned Classes
- `Person` (abstract base class for shared identity/contact fields)
- `Employee` (extends `Person`, stores hours worked)
- `siteManager` (extends `Person`, tracks employees on site)
- `SiteSystem` (main workflow/menu logic)
- `Main` (application entry point)

### Work Division Between Partners
- Partner A: Domain model and inheritance structure (`Person`, `Employee`, `siteManager`)
- Partner B: Console flow and feature implementation (`SiteSystem`, menu options, input handling)
- Shared: Testing flows, bug fixes, and output formatting

## Sprint 2 - The Build

### What Was Implemented
- Created an OOP structure with inheritance (`Person` -> `Employee` / `siteManager`)
- Built a menu-based system in `SiteSystem`
- Implemented:
  - Option 2: lookup employee and display hours
  - Option 3: add hours to existing employee total
  - Option 4: add new hire and generate random ID (`100-999`)
  - Option 5: display all employee summaries
- Added validation messaging such as "Employee ID not found"

### What Changed from the Original Plan
- Employee lists needed synchronization between manager tracking and the main `people` list
- Print logic was adjusted to use summaries instead of object references
- Input handling was refined to avoid scanner newline issues

### Challenges Encountered
- New hires were not appearing in all views because they were added to only one list
- Scanner input sequencing (`nextInt()` and `nextLine()`) caused skipped fields
- Incorrect method usage when updating hours (getter vs setter)

### How Challenges Were Solved
- Added new hires to both relevant collections where needed
- Used proper newline consumption before string input
- Switched to `setHoursWorked(getHoursworked() + hourAdd)` pattern
- Added clearer loop logic and not-found messages

## Sprint 3 - The Reflection

### What Works Well
- Clear class separation and inheritance-based design
- Menu options cover core employee management tasks
- Hours update and employee lookup workflows function as expected
- Program compiles and runs as a clean console app

### What to Improve with More Time
- Replace in-memory lists with persistent storage (file or database)
- Add stronger input validation and exception handling
- Implement role-based permissions (manager vs employee actions)
- Refactor naming/style (`siteManager` -> `SiteManager`) and add unit tests

### Java Concepts Used Most
- Classes and objects
- Inheritance and abstract classes
- Method overriding
- ArrayLists and loops
- Type checking/casting (`instanceof`)
- User input with `Scanner`

### What Was Learned
- Planning helps, but implementation details always evolve
- Data consistency between collections matters in real features
- Input handling in console apps requires careful sequencing
- OOP design makes code easier to extend as requirements grow
