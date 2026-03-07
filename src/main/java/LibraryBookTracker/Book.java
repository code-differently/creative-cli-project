package LibraryBookTracker;

public class Book {


        // Private fields
        private String title;
        private String author;
        private boolean isAvailable;

        // Constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true; // default value
        }

        // Getter for title
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
            return "Book Title: " + title +
                    ", Author: " + author +
                    ", Available: " + isAvailable;
        }
    }

