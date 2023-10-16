package Mement;

import java.util.ArrayList;
import java.util.List;

// Originator class
class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Getter methods for the book attributes
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // Setter methods for the book attributes
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // Memento inner class
    static class BookMemento {
        private final String title;
        private final String author;
        private final int yearPublished;

        public BookMemento(String title, String author, int yearPublished) {
            this.title = title;
            this.author = author;
            this.yearPublished = yearPublished;
        }

        // Getter methods for the book attributes
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYearPublished() {
            return yearPublished;
        }
    }

    // Create a memento of the current state of the book
    public BookMemento createMemento() {
        return new BookMemento(title, author, yearPublished);
    }

    // Restore the state of the book from a memento
    public void restoreMemento(BookMemento memento) {
        this.title = memento.getTitle();
        this.author = memento.getAuthor();
        this.yearPublished = memento.getYearPublished();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}

// Caretaker class
class BookManager {
    private List<Book.BookMemento> mementos = new ArrayList<>();
    private Book book;

    public BookManager(Book book) {
        this.book = book;
    }

    // Save the current state of the book to a memento
    public void save() {
        mementos.add(book.createMemento());
    }

    // Restore the most recent state of the book from a memento
    public void undo() {
        if (mementos.isEmpty()) {
            System.out.println("Cannot undo - no previous state available.");
        } else {
            Book.BookMemento memento = mementos.remove(mementos.size() - 1);
            book.restoreMemento(memento);
        }
    }

    @Override
    public String toString() {
        return "BookManager{" +
                "mementos=" + mementos +
                ", book=" + book +
                '}';
    }
}

public class Memento {
    public static void main(String[] args) {
        // Create a new book
        Book book = new Book("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1994);

        // Create a book manager to manage the book's state
        BookManager manager = new BookManager(book);

        // Save the current state of the book
        manager.save();

        // Change the book's title and author
        book.setTitle("Head First Design Patterns");
        book.setAuthor("Elisabeth Freeman, Eric Freeman, Bert Bates, Kathy Sierra");
        book.setYearPublished(2004);

        // Save the updated state of the book
        manager.save();

        // Undo the last change to the book
        manager.undo();

        // Print the current state of the book
        System.out.println(book);

        // Undo the last change to the book again
        manager.undo();

        // Print the current state of the book
        System.out.println(book);

        // Undo the last change to the book again (this time it should fail)
        manager.undo();
    }
}
