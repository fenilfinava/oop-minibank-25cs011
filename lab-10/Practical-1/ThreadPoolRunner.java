import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            });
        }

        pool.shutdown();
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        System.out.println("All pool tasks completed");
    }
}
