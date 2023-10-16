public class LazySingleton {
    public static void main(String[] args){
        RootUser1 a = RootUser1.getInstance();
    }
}

class RootUser1{
    public static RootUser1 root;
    private RootUser1(){
        System.out.println("Check");
    }

    static RootUser1 getInstance(){//Object is only created when getInstance method is called
        if(root==null){
            root = new RootUser1();
        }
        return root;
    }
}