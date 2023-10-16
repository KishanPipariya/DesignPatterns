public class SynchronizedSingleton {
    public static void main(String[] args) {
        //Threads which creates multiple instances
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                RootUser2 root = RootUser2.getInstance();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                RootUser2 root = RootUser2.getInstance();
            }
        });
        t.start();
        t1.start();
    }
}
    class RootUser2{
        public static RootUser2 root;
        private RootUser2(){
            System.out.println("Check");
        }

        public static synchronized RootUser2 getInstance(){
            if(root == null) { //Root user created if one does not exist
                root = new RootUser2();
            }
            return root;

        }

    }

