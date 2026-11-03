// Practical 9 - Program 3: Parallel Array Summation (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Multi-Threaded Parallel Array Summation ===");

        System.out.print("Enter array size (e.g. 100000): ");
        int size = sc.nextInt();
        System.out.print("Enter number of worker threads (e.g. 4): ");
        int threads = sc.nextInt();

        ArraySum sharedSum = new ArraySum();
        int chunk = size / threads;
        Thread[] threadPool = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            final int tId = i;
            threadPool[i] = new Thread(() -> {
                long partial = 0;
                for (int j = 0; j < chunk; j++) partial += 1;
                sharedSum.add(partial);
            });
            threadPool[i].start();
        }

        for (Thread t : threadPool) t.join();

        System.out.println("\nSequential Expected Sum: " + size);
        System.out.println("Parallel Total Sum: " + sharedSum.getTotal());
        System.out.println("Verification: " + (size == sharedSum.getTotal() ? "PASSED (100% Match)" : "FAILED"));
    }
}
