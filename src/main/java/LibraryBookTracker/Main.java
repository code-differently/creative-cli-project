package LibraryBookTracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner reads user input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // One Library object manages the whole system
        Library library = new Library();

        // Add starter books so the app has data at launch
        addStarterBooks(library);

        // Start the menu loop
        startApplication(scanner, library);

        // Close scanner at the end of the program
        scanner.close();
    }

    // Controls the main loop of the application
    public static void startApplication(Scanner scanner, Library library) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getValidatedMenuChoice(scanner);

            switch (choice) {
                case 1:
                    addBook(scanner, library);
                    break;
                case 2:
                    library.displayAllBooks();
                    break;
                case 3:
                    library.displayAvailableBooks();
                    break;
                case 4:
                    library.displayBorrowedBooks();
                    break;
                case 5:
                    borrowBook(scanner, library);
                    break;
                case 6:
                    returnBook(scanner, library);
                    break;
                case 7:
                    searchBook(scanner, library);
                    break;
                case 8:
                    System.out.println("Thank you for visiting M&W Library !");
                    running = false;
                    break;
            }
        }
    }

    // Prints the main menu for the user
    public static void printMenu() {
        System.out.println("\n===== M&W Library Book Tracker =====");
        System.out.println("1. Add a book");
        System.out.println("2. View all books");
        System.out.println("3. View available books");
        System.out.println("4. View borrowed books");
        System.out.println("5. Borrow a book by ID");
        System.out.println("6. Return a book by ID");
        System.out.println("7. Search for a book");
        System.out.println("8. Exit");
        System.out.print("Choose an option (1-8): ");
    }

    // Validates menu input so the program does not crash on bad input
    public static int getValidatedMenuChoice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= 8) {
                return choice;
            }

            System.out.println("Invalid menu option. Please choose 1-8.");
        }
    }

    // Adds starter books to make the program easier to test
    public static void addStarterBooks(Library library) {
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("Maze Runner", "James Dashner");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Godfather", "Mario Puzo");
        library.addBook("Harry Potter", "J. K. Rowling");
    }

    // Collects input for a new book and sends it to the Library
    public static void addBook(Scanner scanner, Library library) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        library.addBook(title, author);
    }

    // Lets the user borrow a book by entering the book's ID
    public static void borrowBook(Scanner scanner, Library library) {
        System.out.print("Enter the ID of the book to borrow: ");
        int id = getValidatedPositiveNumber(scanner);
        library.borrowBookById(id);
    }

    // Lets the user return a book by entering the book's ID
    public static void returnBook(Scanner scanner, Library library) {
        System.out.print("Enter the ID of the book to return: ");
        int id = getValidatedPositiveNumber(scanner);
        library.returnBookById(id);
    }

    // Gives the user two search options: by ID or by title
    public static void searchBook(Scanner scanner, Library library) {
        System.out.println("Search by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Choose an option: ");

        int searchChoice = getValidatedSearchChoice(scanner);

        if (searchChoice == 1) {
            System.out.print("Enter book ID: ");
            int id = getValidatedPositiveNumber(scanner);
            library.searchBookById(id);
        } else {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            library.searchBookByTitle(title);
        }
    }

    // Validates search menu options
    public static int getValidatedSearchChoice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2) {
                return choice;
            }

            System.out.println("Please choose 1 or 2.");
        }
    }

    // Validates positive number input for book IDs
    public static int getValidatedPositiveNumber(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();
            scanner.nextLine();

            if (number > 0) {
                return number;
            }

            System.out.println("Please enter a number greater than 0.");
        }
    }
}