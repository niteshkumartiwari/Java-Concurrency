import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    static private Lock lock= new ReentrantLock();
    static private Condition added= lock.newCondition();
    static private Condition removed= lock.newCondition();
    static private int count=0;
    static private int MAX_COUNT=10;

    static class Producer extends Thread{
        @Override
        public void run(){
            produce();
        }

        public void produce(){
            lock.lock();
            try{
                while (count==MAX_COUNT)
                    removed.await();

                count++;//added Data
                System.out.println("Producing Data");
                added.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Consumer extends Thread{
        @Override
        public void run() {
            consumer();
        }

        public void consumer(){
            lock.lock();
            try{
                while (count==0)
                    added.await();
                count--;//use data
                System.out.println("Consuming Data");
                removed.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.lock();
            }
        }
    }

    public static void main(String[] args) {
        Thread consumer= new Consumer();
        Thread producer= new Producer();

        consumer.start();
        producer.start();
    }
}
