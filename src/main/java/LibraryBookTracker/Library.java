package LibraryBookTracker;

import java.util.ArrayList;

public class Library {

    // Using ArrayList because the number of books can grow over time
    private ArrayList<Book> books;

    // Constructor creates an empty list when the library starts
    public Library() {
        books = new ArrayList<>();
    }

    // Adds a new book object into the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Displays every book in the library
    public void displayAllBooks() {
        // This condition helps prevent printing an empty list with no explanation
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        // Loop goes through every book in the collection and prints it
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Lets a user borrow a book by title
    public void borrowBook(String title) {
        for (Book book : books) {
            // equalsIgnoreCase lets the user type upper/lowercase without breaking the search
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("You borrowed the book: " + book.getTitle());
                } else {
                    System.out.println("That book is already borrowed.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Lets a user return a book by title
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("You returned the book: " + book.getTitle());
                } else {
                    System.out.println("That book was already available.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Searches for one book and prints its information
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book not found.");
    }
}
