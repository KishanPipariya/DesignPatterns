import java.util.Scanner;
class Facade {
    void choice(){
        Scanner sc = new Scanner(System.in);
        int a;
        String s;
        System.out.println("Enter 1 to search for author:");
        s = sc.nextLine();
        if(s.equals("1")){
            AuthorFactory fa = new AuthorFactory();
            String in = sc.nextLine();
            Author auth = fa.getAuthor(in);
            auth.listBooks();
        }
    }
}

class FacadeDemo{
    public static void main(String[] args){
        Facade ob = new Facade();
        ob.choice();
    }
}


