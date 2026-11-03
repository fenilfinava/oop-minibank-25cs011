// Practical 9 - Program 1: Counter Race Condition vs Synchronized (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    static class RawCounter {
        private int count = 0;
        public void increment() { count++; } // unsynchronized!
        public int getCount() { return count; }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Multithreading Race Condition Demonstrator ===");

        System.out.print("Enter number of concurrent threads (e.g. 5): ");
        int numThreads = sc.nextInt();
        System.out.print("Enter increments per thread (e.g. 2000): ");
        int incPerThread = sc.nextInt();

        int expected = numThreads * incPerThread;

        // 1. Unsynchronized Counter
        RawCounter rawCounter = new RawCounter();
        Thread[] tList1 = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            tList1[i] = new Thread(() -> {
                for (int j = 0; j < incPerThread; j++) rawCounter.increment();
            });
            tList1[i].start();
        }
        for (Thread t : tList1) t.join();

        // 2. Synchronized Counter
        Counter syncCounter = new Counter();
        Thread[] tList2 = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            tList2[i] = new Thread(() -> {
                for (int j = 0; j < incPerThread; j++) syncCounter.increment();
            });
            tList2[i].start();
        }
        for (Thread t : tList2) t.join();

        System.out.println("\n--- Thread Execution Results ---");
        System.out.println("Expected Final Count: " + expected);
        System.out.println("Unsynchronized Counter: " + rawCounter.getCount() + " (Race Condition occurred!)");
        System.out.println("Synchronized Counter: " + syncCounter.getCount() + " (Thread-Safe & Exact!)");
    }
}
