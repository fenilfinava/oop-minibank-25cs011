import exception.*;
import model.*;
import service.BankSession;

public class MiniBank {
    public static void main(String[] args) {
        try (BankSession session = new BankSession()) {
            SavingsAccount acc = new SavingsAccount("Alice", 1000, 500);

            try {
                acc.withdraw(5000);
            } catch (InsufficientFundsException e) {
                System.out.println("Withdrawal failed: short by " + e.getShortfall());
            } catch (InvalidAmountException e) {
                System.out.println("Invalid amount: " + e.getMessage());
            }

            System.out.println("Account balance remains: " + acc.getBalance());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
