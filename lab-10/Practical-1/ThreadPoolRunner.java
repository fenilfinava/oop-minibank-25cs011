// Practical 10 - Program 1: Fixed Thread Pool Task Runner (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Fixed Thread Pool Task Scheduler ===");

        System.out.print("Enter thread pool worker capacity (e.g. 3): ");
        int poolSize = sc.nextInt();
        System.out.print("Enter total computational tasks to dispatch (e.g. 6): ");
        int totalTasks = sc.nextInt();

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        System.out.println("\nDispatching tasks to executor pool...");
        for (int i = 1; i <= totalTasks; i++) {
            final int taskId = i;
            pool.submit(() -> {
                String thread = Thread.currentThread().getName();
                System.out.println("[" + thread + "] started Task #" + taskId);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
                System.out.println("[" + thread + "] COMPLETED Task #" + taskId);
            });
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("All tasks executed and thread pool gracefully terminated.");
    }
}
