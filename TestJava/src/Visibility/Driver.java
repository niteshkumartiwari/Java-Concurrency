package Visibility;

public class Driver implements Runnable{
    private static int counter1=0;
    private int counter2=0;

    public static void main(String[] args) {
        Driver driver= new Driver();
        Driver driver2= new Driver();
        Thread t1= new Thread(driver);
        Thread t2= new Thread(driver);
        Thread t3= new Thread(driver2);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized static void func1(){
        System.out.println("func1(): "+ Thread.currentThread().getName() +" start value: "+ counter1);
        counter1++;
        System.out.println("func1(): "+Thread.currentThread().getName() +" end value: "+ counter1);
    }

    public synchronized void func2(){
        System.out.println("func2(): "+Thread.currentThread().getName() +" start value: "+ counter2);
        counter2++;
        System.out.println("func2(): "+Thread.currentThread().getName() +" end value: "+ counter2);
    }

    @Override
    public void run() {
        func1();
        func2();
    }
}
