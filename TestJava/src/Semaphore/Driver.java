package Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Driver {
    static class SlowService implements Runnable{
        private Semaphore semaphore;

        SlowService(Semaphore semaphore){
            this.semaphore=semaphore;
        }

        @Override
        public void run() {
            //some processing
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("IO Call to the slow service");
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore= new Semaphore(3);
        ExecutorService service= Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i-> service.execute(new SlowService(semaphore)));

        //service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }
}
