import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        //get count of available cores
        int coreCount=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newFixedThreadPool(coreCount);

        for(int i=0;i<100;i++){
            service.execute(new Task());
        }

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
