import model.SavingsAccount;
import service.AccountWorker;

public class MiniBank {
    public static void main(String[] args) throws InterruptedException {
        SavingsAccount acc = new SavingsAccount("SharedAccount", 0, 0);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new AccountWorker(acc, 1000, 1), "Worker-" + (i + 1));
            System.out.println("Created and starting: " + threads[i].getName());
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
            System.out.println("Finished: " + t.getName());
        }

        System.out.println("Final account balance (expected 10000): " + acc.getBalance());
    }
}
