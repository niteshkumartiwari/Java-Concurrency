import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ExecutorServiceDemo {
    public static void main(String[] args) {
        //get count of available cores
        int coreCount=Runtime.getRuntime().availableProcessors();

        //Fixed Size-Thread Pool
        //creates no. of threads equal to fixed size
        //ExecutorService service= Executors.newFixedThreadPool(coreCount);

        //Cached ThreadPool
        //Doesn't have a blocking queue inside the service but a synchronous variable
        //Which will create a new thread if all current threads are busy. And has a
        //life cycle method to kill the threads if idle for 60sec.
        //ExecutorService service= Executors.newCachedThreadPool();

        //Scheduled ThreadPool
        //Creates a task after delay
        ScheduledExecutorService service=Executors.newScheduledThreadPool(10);

        //task to run after 10 sec delay
        service.schedule(new Task(),10, TimeUnit.SECONDS);

        //task to run repeatedly after 10 sec
        service.scheduleAtFixedRate(new Task(),5,10,TimeUnit.SECONDS);


//        for(int i=0;i<100;i++){
//            service.execute(new Task());
//        }

        //Single ThreadPool
        //If we want sequential execution of the tasks

        System.out.println("Thread name: "+ Thread.currentThread().getName());
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        //some CPU intensive operations
        System.out.println("Thread name: "+ Thread.currentThread().getName());
    }
}
