public class EagerSingleton {
    public static void main(String[] args){
        RootUser a = RootUser.getInstance();
    }
}

class RootUser{
    public static RootUser root= new RootUser();//Object is created regardless of whether the getInstance method is called
    private RootUser(){

    }

    static RootUser getInstance(){
        System.out.println("Root User");
        return root;
    }
}
