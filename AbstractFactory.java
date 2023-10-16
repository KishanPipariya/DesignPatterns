public abstract class AbstractFactory {
    abstract Author getAuthor(String name);
}

class FactoryProducer{//Generates  a factory based on requirement
    public static AbstractFactory getFactory(String choice){
         return new AuthorFactory();//Defined in Factory.java
    }
}

class AbstractFactoryTest{
    public static void main(String[] args){
        AbstractFactory authorFactory = FactoryProducer.getFactory("Author");
        Author auth1 = authorFactory.getAuthor("Sanderson");
        auth1.listBooks();//List all books written by an author
    }
}