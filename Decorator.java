public class Decorator {
    public static void main(String args[]){
        Author sanderson = new Sanderson();
        Author alive = new LivingDecorator(new Sanderson());
        sanderson.listBooks();
        System.out.println("Decorated class:");
        alive.listBooks();
    }
}

class AuthorDecorator implements Author{
    protected  Author decoratedAuthor;
    public AuthorDecorator(Author decoratedAuthor ){
        this.decoratedAuthor = decoratedAuthor;
    }

    public void listBooks() {
        decoratedAuthor.listBooks();
    }
}

class LivingDecorator extends AuthorDecorator{
    public LivingDecorator(Author decoratedAuthor ){
        super(decoratedAuthor);
    }

    @Override
    public void listBooks() {
        decoratedAuthor.listBooks();
        setLiving(decoratedAuthor);
    }

    private void setLiving(Author deoratedAuthor){
        System.out.println("Alive");
    }
}
