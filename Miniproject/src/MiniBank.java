import exception.BankException;
import model.SavingsAccount;
import service.TransactionProcessor;

public class MiniBank {
    public static void main(String[] args) throws InterruptedException {
        SavingsAccount a1 = new SavingsAccount("User1", 5000, 500);
        SavingsAccount a2 = new SavingsAccount("User2", 5000, 500);

        TransactionProcessor processor = new TransactionProcessor();

        for (int i = 0; i < 5; i++) {
            processor.submit(() -> {
                try {
                    a1.deposit(100);
                } catch (Exception e) {
                }
            });
        }

        processor.stop();
        System.out.println("Balance after batch deposits: " + a1.getBalance());

        Thread t1 = new Thread(() -> {
            try {
                TransactionProcessor.transferSafe(a1, a2, 500);
            } catch (BankException e) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                TransactionProcessor.transferSafe(a2, a1, 300);
            } catch (BankException e) {
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final A1 balance: " + a1.getBalance());
        System.out.println("Final A2 balance: " + a2.getBalance());
    }
}
