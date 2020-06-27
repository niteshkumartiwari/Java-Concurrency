public class VolatileMain {
    public static void main(String[] args) throws Exception{
        VolatileData data= new VolatileData();

        Thread t1= new VolatileThread(data);
        Thread t2= new VolatileThread(data);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter: "+data.getCounter());
    }
}
