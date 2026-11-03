// Practical 9 - Part B: Concurrent Banking Thread-Safety (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class PartB_MiniBank {
    static class ThreadSafeAccount {
        private long balance;
        private final ReentrantLock lock = new ReentrantLock();

        public ThreadSafeAccount(long initial) { this.balance = initial; }

        public void deposit(long amount) {
            lock.lock();
            try {
                balance += amount;
            } finally {
                lock.unlock();
            }
        }

        public long getBalance() { return balance; }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 09: Multi-Threaded Concurrent Deposits ===");

        System.out.print("Enter initial account balance: Rs. ");
        long initBal = sc.nextLong();
        System.out.print("Enter number of concurrent deposit threads (e.g. 10): ");
        int numThreads = sc.nextInt();
        System.out.print("Enter deposit amount per thread: Rs. ");
        long depAmount = sc.nextLong();

        ThreadSafeAccount account = new ThreadSafeAccount(initBal);
        Thread[] threads = new Thread[numThreads];

        System.out.println("\nSpawning " + numThreads + " concurrent threads...");
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> account.deposit(depAmount), "Worker-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        long expected = initBal + (numThreads * depAmount);
        System.out.println("Final Account Balance: Rs. " + account.getBalance());
        System.out.println("Expected Balance: Rs. " + expected);
        System.out.println("Thread-Safety Status: " + (account.getBalance() == expected ? "VERIFIED (0 Lost Updates)" : "FAILED"));
    }
}
