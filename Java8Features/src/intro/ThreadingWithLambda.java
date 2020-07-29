package intro;

public class ThreadingWithLambda {
    public static void main(String[] args) {
        Runnable r=()->{
            for(int i=0;i<100;i++){
                System.out.println("Child Thread");
            }
        };

        Thread t= new Thread(r);
        t.start();

        for(int i=0;i<100;i++){
            System.out.println("Main Thread");
        }
    }
}
