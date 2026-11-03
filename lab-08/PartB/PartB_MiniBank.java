// Practical 8 - Part B: MiniBank Exception Hierarchy (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class PartB_MiniBank {
    static class BankException extends Exception {
        public BankException(String msg) { super(msg); }
    }

    static class InsufficientFundsException extends BankException {
        private long shortfall;
        public InsufficientFundsException(String msg, long shortfall) {
            super(msg); this.shortfall = shortfall;
        }
        public long getShortfall() { return shortfall; }
    }

    static class InvalidAmountException extends BankException {
        public InvalidAmountException(String msg) { super(msg); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 08: Fault-Tolerant Banking Exceptions ===");

        long balance = 5000;
        System.out.println("Account Initial Balance: Rs. " + balance);

        System.out.print("Enter amount to withdraw (try > 5000 for shortfall, or <= 0 for invalid): Rs. ");
        long wAmt = sc.nextLong();

        try {
            if (wAmt <= 0) {
                throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
            }
            if (wAmt > balance) {
                throw new InsufficientFundsException("Insufficient account funds!", wAmt - balance);
            }
            balance -= wAmt;
            System.out.println("Withdrawal Approved! Remaining Balance: Rs. " + balance);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Failed: " + e.getMessage() + " Shortfall: Rs. " + e.getShortfall());
        } catch (InvalidAmountException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        } finally {
            System.out.println("Transaction Audit: Session logged to banking ledger.");
        }
    }
}
