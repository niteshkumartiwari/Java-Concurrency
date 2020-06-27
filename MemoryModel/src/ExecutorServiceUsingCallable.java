import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceUsingCallable{
    public static void main(String[] args) throws Exception {
        ExecutorService service= Executors.newFixedThreadPool(10);
        Future<Integer> future=service.submit(new Task());

        //perform some unrelated task

        Integer result=future.get();//blocking operation
        System.out.println(result);
    }

    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }
}
