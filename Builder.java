public class Builder {
    public static void main(String[] args){
        BookBuilder book1 = new BookBuilder();
        book1.setTitle("The way of Kings");
        book1.setGenre(new String[]{"Fantasy"});
        book1.setAuthor(new String[]{"Brandon Sanderson"});
        Book b1 = book1.getBook();
        System.out.println(b1.Title);
        System.out.println(b1.Author[0]);
        System.out.println(b1.Genre[0]);
    }
}

class Book {
    String Title;
    boolean isSerial;
    String[] Genre, Author;
    //String Author, boolean isSerial, String[] genre
    Book(String Title, String[] Author, String[] Genre){
        this.Title = Title;
        this.Author = Author;
        this.Genre = Genre;
    }

    public String toString(){
        return "Book[Title=" + Title + ", Author="+ Author[0] + ", genre=" + Genre[0];
    }

}

class BookBuilder{
    private String Title;
    private String[] Genre, Author;

    public BookBuilder setTitle(String Title){
        this.Title = Title;
        return this;
    }

    public BookBuilder setGenre(String[] Genre){
        this.Genre = Genre;
        return this;
    }

    public BookBuilder setAuthor(String[] Author){
        this.Author = Author;
        return this;
    }


    public Book getBook(){
        return new Book(Title, Author, Genre);
    }
}