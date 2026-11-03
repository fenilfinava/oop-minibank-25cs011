// Practical 10 - Program 2: Bounded Buffer Producer-Consumer (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public ProducerConsumer(int capacity) { this.capacity = capacity; }

    public synchronized void produce(int val) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Queue FULL! Producer waiting...");
            wait();
        }
        queue.add(val);
        System.out.println("Produced: " + val + " (Buffer Size: " + queue.size() + "/" + capacity + ")");
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue EMPTY! Consumer waiting...");
            wait();
        }
        int val = queue.poll();
        System.out.println("Consumed: " + val + " (Buffer Size: " + queue.size() + "/" + capacity + ")");
        notifyAll();
        return val;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Producer-Consumer wait() / notifyAll() Demo ===");

        System.out.print("Enter buffer capacity (e.g. 2): ");
        int cap = sc.nextInt();
        System.out.print("Enter total items to transfer (e.g. 5): ");
        int items = sc.nextInt();

        ProducerConsumer pc = new ProducerConsumer(cap);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= items; i++) {
                    pc.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= items; i++) {
                    pc.consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {}
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Producer-Consumer coordination completed safely.");
    }
}
