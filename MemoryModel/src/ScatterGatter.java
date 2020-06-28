import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScatterGatter {
    static ExecutorService threadPool= Executors.newFixedThreadPool(4);
    static private Set<Integer> getPrice(int productId) throws InterruptedException{
        Set<Integer> prices= Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch= new CountDownLatch(3);
        threadPool.submit(new Task("url1",productId,prices,latch));
        threadPool.submit(new Task("url2",productId,prices,latch));
        threadPool.submit(new Task("url3",productId,prices,latch));

        latch.await(3, TimeUnit.SECONDS);

        return prices;
    }
    public static void main(String[] args) throws Exception{
        System.out.println("Getting call for some product from three services");
        Set<Integer> prices= getPrice(12);
        for(Integer val: prices)
            System.out.println("Price: "+val);
    }
    public static class Task implements Runnable{
        private String url;
        private int productId;
        private Set<Integer> prices;
        private CountDownLatch latch;

        //constructor
        public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
            this.url = url;
            this.productId = productId;
            this.prices = prices;
            this.latch = latch;
        }

        @Override
        public void run() {
            int price=0;
            System.out.println("Making http call for: "+url+" and productId: "+productId);
            price= new Random().nextInt(100);
            prices.add(price);
            latch.countDown();
        }
    }
}
