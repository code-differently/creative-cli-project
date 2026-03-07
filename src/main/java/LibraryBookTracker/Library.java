package LibraryBookTracker;

import java.util.ArrayList;

public class Library {

    // Using ArrayList because the number of books can grow as users add more
    private ArrayList<Book> books;

    // This keeps track of the next ID to assign to a new book
    private int nextBookId;

    // Constructor creates the book list and starts IDs at 1
    public Library() {
        books = new ArrayList<>();
        nextBookId = 1;
    }

    // Creates and adds a new book using the next available ID
    public void addBook(String title, String author) {
        Book newBook = new Book(nextBookId, title, author);
        books.add(newBook);
        nextBookId++;

        System.out.println("Book added successfully.");
        System.out.println(newBook);
    }

    // Displays every book in the system
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n--- All Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Displays only books that are currently available
    public void displayAvailableBooks() {
        boolean foundAvailable = false;

        System.out.println("\n--- Available Books ---");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                foundAvailable = true;
            }
        }

        if (!foundAvailable) {
            System.out.println("No available books right now.");
        }
    }

    // Displays only books that are currently borrowed
    public void displayBorrowedBooks() {
        boolean foundBorrowed = false;

        System.out.println("\n--- Borrowed Books ---");
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book);
                foundBorrowed = true;
            }
        }

        if (!foundBorrowed) {
            System.out.println("No borrowed books right now.");
        }
    }

    // Lets the user borrow a book using its unique ID
    public void borrowBookById(int id) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("That book is already borrowed.");
            return;
        }

        book.setAvailable(false);
        System.out.println("You borrowed: " + book.getTitle());
    }

    // Lets the user return a book using its unique ID
    public void returnBookById(int id) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("That book is already available.");
            return;
        }

        book.setAvailable(true);
        System.out.println("You returned: " + book.getTitle());
    }

    // Searches for a book by ID
    public void searchBookById(int id) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book found:");
            System.out.println(book);
        }
    }

    // Searches for books by title
    // Using contains() makes searching more flexible than exact matching
    public void searchBookByTitle(String title) {
        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books matched that title.");
        }
    }

    // Helper method used to find one book by its unique ID
    // Keeping this logic in one place avoids repeated code
    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}