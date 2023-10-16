public class DoubleCheckedLocking {
    public static void main(String[] args) {
        //Threads which creates multiple instances
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                RootUser3 root = RootUser3.getInstance();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                RootUser3 root = RootUser3.getInstance();
            }
        });
        t.start();
        t1.start();
    }
}
class RootUser3{
    public static RootUser3 root;
    private RootUser3(){
        System.out.println("Check");
    }

    public static RootUser3 getInstance(){
        if(root == null) {//Root user created if one does not exist
            synchronized (RootUser3.class){
                if(root==null)
                    root = new RootUser3();
            }
        }
        return root;

    }

}


