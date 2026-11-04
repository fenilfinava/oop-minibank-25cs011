// MiniProject - Module 6: Interactive Exception Driver
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
import java.util.Scanner;

public class Main {
    private static long currentBalance = 5000;
    private static final String ACC_NO = "AC1001";

    public static void withdraw(long amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be strictly greater than zero: " + amount);
        }
        if (amount > currentBalance) {
            throw new InsufficientFundsException(ACC_NO, amount, currentBalance);
        }
        currentBalance -= amount;
        System.out.println("Withdrawal Approved! Amount debited: Rs. " + amount + " | Remaining Balance: Rs. " + currentBalance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("  Module 6: Custom Banking Exception Hierarchy");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");

        System.out.println("Current Account Balance for " + ACC_NO + ": Rs. " + currentBalance);
        System.out.print("\nEnter amount to withdraw (Try > 5000 for shortfall, or <= 0 for invalid): Rs. ");
        long amt = sc.nextLong();

        try {
            withdraw(amt);
        } catch (InsufficientFundsException e) {
            System.out.println("\n[CAUGHT InsufficientFundsException]: " + e.getMessage());
            System.out.println("  Diagnostic Details -> Account: " + e.getAccountNumber());
            System.out.println("  Requested Amount   -> Rs. " + e.getRequestedAmount());
            System.out.println("  Available Balance  -> Rs. " + e.getAvailableBalance());
            System.out.println("  Calculated Shortfall: Rs. " + e.getShortfall());
        } catch (InvalidAmountException e) {
            System.out.println("\n[CAUGHT InvalidAmountException]: " + e.getMessage());
        } finally {
            System.out.println("\n[FINALLY BLOCK] Audit log verified: Banking transaction lifecycle concluded.");
        }
    }
}
