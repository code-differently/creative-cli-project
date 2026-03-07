package LibraryBookTracker;

public class Book {


        // Private fields
        private String title;
        private String author;
        private boolean isAvailable;
        private int id;

        // Constructor
        public Book(int id, String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true; // default value
            this.id = id;
        }


        // Getter for title
    public int getId() {
        return id;
    }

    public String getTitle() {
            return title;
        }

        // Setter for title
        public void setTitle(String title) {
            this.title = title;
        }

        // Getter for author
        public String getAuthor() {
            return author;
        }

        // Setter for author
        public void setAuthor(String author) {
            this.author = author;
        }

        // Check availability
        public boolean isAvailable() {
            return isAvailable;
        }

        // Set availability
        public void setAvailable(boolean available) {
            this.isAvailable = available;
        }

        // toString method

    @Override
    public String toString() {
        String status;

        if (isAvailable) {
            status = "Available";
        } else {
            status = "Borrowed";
        }

        return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + status;

        }
    }

