import java.util.ArrayList;
import java.util.List;

interface Component{ //Used for defining methods of component
    void display();
    //String getSeries();
}

class Leaf implements Component{//Each leaf is a book in a series
    String title;// Title of the book
    Leaf(String title){
        this.title = title;
    }

    public void display(){
        System.out.println("Title:" + title);
    }
}

class Composite implements Component{//Hold a collection of books in a series
    String seriesName;
    List<Component> components = new ArrayList<>();
    Composite(String seriesName){
        super();
        this.seriesName = seriesName;
    }

    public void addComponent(Component com){//Adds a book in a series
        components.add(com);
    }

    @Override
    public void display() {
        for(Component c: components){
            c.display();
        }
    }
}

class CompositeTest{
    public static void main(String[] args){
        Component tlt = new Leaf("The Lightning Thief");
        Component som = new Leaf("Sea of monsters");
        Component tc = new Leaf("The Titan's Curse");
        Component tbl = new Leaf("The Battle of the Labyrinth");
        Component tlo = new Leaf("The Last olympian");

        Composite per = new Composite("Percy Jackson and the Olympians");

        per.addComponent(tlt);
        per.addComponent(som);
        per.addComponent(tc);
        per.addComponent(tbl);
        per.addComponent(tlo);

        per.display();

    }
}