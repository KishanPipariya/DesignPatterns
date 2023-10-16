
interface BookState {
    void issue(Book1 book1);
    void returnBook(Book1 book1);
    void reserve(Book1 book1);
    void cancelReservation(Book1 book1);
}

class AvailableState implements BookState {
    @Override
    public void issue(Book1 book1) {
        book1.setState(new IssuedState());
        System.out.println("Book " + book1.getTitle() + " is issued to the borrower.");
    }

    @Override
    public void returnBook(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is already available.");
    }

    @Override
    public void reserve(Book1 book1) {
        book1.setState(new ReservedState());
        System.out.println("Book " + book1.getTitle() + " is reserved.");
    }

    @Override
    public void cancelReservation(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is not reserved.");
    }
}

class IssuedState implements BookState {
    @Override
    public void issue(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is already issued.");
    }

    @Override
    public void returnBook(Book1 book1) {
        book1.setState(new AvailableState());
        System.out.println("Book " + book1.getTitle() + " is returned.");
    }

    @Override
    public void reserve(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is already issued.");
    }

    @Override
    public void cancelReservation(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is already issued.");
    }
}

class ReservedState implements BookState {
    @Override
    public void issue(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is already reserved.");
    }

    @Override
    public void returnBook(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is reserved and cannot be returned.");
    }

    @Override
    public void reserve(Book1 book1) {
        System.out.println("Book " + book1.getTitle() + " is already reserved.");
    }

    @Override
    public void cancelReservation(Book1 book1) {
        book1.setState(new AvailableState());
        System.out.println("Reservation for book " + book1.getTitle() + " is cancelled.");
    }
}

class Book1 {
    private String title;
    private BookState state;

    public Book1(String title) {
        this.title = title;
        this.state = new AvailableState();
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void issue() {
        this.state.issue(this);
    }

    public void returnBook() {
        this.state.returnBook(this);
    }

    public void reserve() {
        this.state.reserve(this);
    }

    public void cancelReservation() {
        this.state.cancelReservation(this);
    }
}

public class State {
    public static void main(String[] args) {
        // Create a book
        Book1 book1 = new Book1("Java Programming");

        // Issue the book
        book1.issue();

        // Return the book
        book1.returnBook();

        // Reserve the book
        book1.reserve();

        // Cancel reservation
        book1.cancelReservation();
    }
}
