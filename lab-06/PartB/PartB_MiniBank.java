// Practical 6 - Part B: WithdrawRule Strategy & Interface (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class PartB_MiniBank {
    @FunctionalInterface
    interface WithdrawRule {
        boolean allow(long currentBalance, long withdrawAmount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 06: WithdrawRule Interface Strategy ===");

        System.out.print("Enter Account Current Balance: Rs. ");
        long bal = sc.nextLong();
        System.out.print("Enter Desired Withdrawal Amount: Rs. ");
        long wAmt = sc.nextLong();

        WithdrawRule minBalRule = (b, a) -> (b - a) >= 1000;
        WithdrawRule maxLimitRule = (b, a) -> a <= 25000;

        boolean pass1 = minBalRule.allow(bal, wAmt);
        boolean pass2 = maxLimitRule.allow(bal, wAmt);

        System.out.println("\n--- Validation Check ---");
        System.out.println("1. Min Balance Rule (remains >= 1000): " + (pass1 ? "PASS" : "FAIL"));
        System.out.println("2. Daily Limit Rule (amount <= 25000): " + (pass2 ? "PASS" : "FAIL"));

        if (pass1 && pass2) {
            System.out.println("-> WITHDRAWAL APPROVED! New Balance: Rs. " + (bal - wAmt));
        } else {
            System.out.println("-> WITHDRAWAL REJECTED by Strategy Rules.");
        }
    }
}
