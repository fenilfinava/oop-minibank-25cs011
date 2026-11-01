import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY = 3;
    private final Queue<Integer> queue = new LinkedList<>();

    public synchronized void produce(int val) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            wait();
        }
        queue.add(val);
        System.out.println("Produced: " + val);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int val = queue.poll();
        System.out.println("Consumed: " + val);
        notifyAll();
        return val;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    pc.produce(i);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    pc.consume();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
