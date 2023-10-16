import java.util.ArrayList;
import java.util.List;
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookBuilder book1 = new BookBuilder();
        book1.setTitle("The way of Kings");
        book1.setGenre(new String[]{"Fantasy"});
        book1.setAuthor(new String[]{"Brandon Sanderson"});
        Book b1 = book1.getBook();
        System.out.println(b1.Title);
        System.out.println(b1.Author[0]);
        System.out.println(b1.Genre[0]);
        Collection col = new Collection();
        col.addBook(b1);
        System.out.println(col);
        Collection coll = col.clone();
        System.out.println(coll);

    }
}
class Collection implements Cloneable{
    private String collectionName;
    List<Book> book1s = new ArrayList<>();

    public String getCollectionName(){
        return collectionName;
    }

    public List<Book> getBooks(){
        return book1s;
    }

    public void setBooks(List<Book> book1s){
        this.book1s = book1s;
    }

    public void addBook(Book b){
        book1s.add(b);
    }

    public String toString(){
        return "Collection[name=" + collectionName + ", books=" + book1s +"]";
    }

    protected Collection clone() throws CloneNotSupportedException{
        Collection col = new Collection();
        for(Book b: this.getBooks()) {
            col.addBook(b);
        }
        return col;
    }


}
