public class Factory {
    public static void main(String[] args){
        AuthorFactory fact;
        fact = new AuthorFactory();
        Author auth = fact.getAuthor("Sanderson");
        auth.listBooks();
    }
}

interface Author{
    void listBooks();
}

class Sanderson implements Author{
    public void listBooks(){
        System.out.println("The Last Empire");
    }
}

class Tolkien implements Author{
    public void listBooks(){
        System.out.println("The fellowship of the ring");
    }
}

class AuthorFactory extends AbstractFactory{
    public Author getAuthor(String inp){
        if(inp.equals("Tolkien")){
            return new Tolkien();
        } else if (inp.equals("Sanderson")) {
            return new Sanderson();
        }
        return null;
    }
}
