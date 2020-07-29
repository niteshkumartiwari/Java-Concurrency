package intro;

public class AnoInnerClassAndLambda {
    public static void main(String[] args) {
        Runnable r= new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    System.out.println("Child class");
            }
        };

        Thread t= new Thread(r);
        t.start();
    }
}
