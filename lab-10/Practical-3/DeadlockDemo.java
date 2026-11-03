// Practical 10 - Program 3: Deadlock Resolution via Lock Ordering (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class DeadlockDemo {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Deadlock Simulation & Resolution Demo ===");
        System.out.println("1. Demonstrate Deadlock-Free Execution via Lock Ordering");
        System.out.print("Enter choice (1): ");
        int ch = sc.nextInt();

        System.out.println("\nExecuting with strict lock ordering (LockA -> LockB)...");
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1: Acquired Lock A");
                try { Thread.sleep(50); } catch (Exception e) {}
                synchronized (lockB) {
                    System.out.println("Thread 1: Acquired Lock B -> Completed work!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockA) { // Always lock A before B to prevent circular wait!
                System.out.println("Thread 2: Acquired Lock A");
                try { Thread.sleep(50); } catch (Exception e) {}
                synchronized (lockB) {
                    System.out.println("Thread 2: Acquired Lock B -> Completed work!");
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Both threads finished safely without any deadlock!");
    }
}
