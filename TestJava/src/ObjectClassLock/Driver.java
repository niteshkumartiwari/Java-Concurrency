package ObjectClassLock;

public class Driver implements Runnable{
    public static void main(String[] args) {
        Driver driver= new Driver();
        Thread t1= new Thread(driver);
        Thread t2= new Thread(driver);
        Driver driver2= new Driver();
        Thread t3= new Thread(driver2);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void LockObject(){
        System.out.println("in ObjectLock block "+ Thread.currentThread().getName()+" start...");
        System.out.println("in ObjectLock block "+ Thread.currentThread().getName()+" end!");
    }

    public synchronized static void LockClass(){
        System.out.println("in ClassLock block "+ Thread.currentThread().getName()+" start...");
        System.out.println("in ClassLock block "+ Thread.currentThread().getName()+" end!");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        LockClass();
    }
}
