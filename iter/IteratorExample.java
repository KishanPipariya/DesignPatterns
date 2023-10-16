package iter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}

class Bookshelf implements Iterable<Book> {
    private List<Book> books;

    public Bookshelf() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookshelfIterator();
    }

    private class BookshelfIterator implements Iterator<Book> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < books.size();
        }

        @Override
        public Book next() {
            return books.get(currentIndex++);
        }

        @Override
        public void remove() {
            books.remove(--currentIndex);
        }
    }
}

public class IteratorExample {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();

        Book book1 = new Book("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1994);
        Book book2 = new Book("Clean Code", "Robert C. Martin", 2008);
        Book book3 = new Book("The Pragmatic Programmer", "Andrew Hunt, David Thomas", 1999);

        bookshelf.addBook(book1);
        bookshelf.addBook(book2);
        bookshelf.addBook(book3);

        // Iterate over the bookshelf using the Iterator pattern
        Iterator<Book> iterator = bookshelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }

        // Remove a book from the bookshelf using the Iterator pattern
        iterator = bookshelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getYearPublished() < 2000) {
                iterator.remove();
            }
        }

        // Print the remaining books in the bookshelf
        System.out.println("Books published after 2000:");
        for (Book book : bookshelf.getBooks()) {
            System.out.println(book);
        }
    }
}
