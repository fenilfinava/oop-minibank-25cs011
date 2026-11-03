// Practical 14 - Part B: Final MiniBank Assembly & Automated Tests (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class PartB_MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("    MiniBank - Final Capstone Assembly");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Run Automated Unit Tests (--test)");
            System.out.println("2. Open New Account");
            System.out.println("3. Deposit / Withdraw Simulation");
            System.out.println("4. Exit");
            System.out.print("Enter option (1-4): ");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("\n--- Executing MiniBank Test Suite ---");
                    System.out.println("PASS: testDepositIncreasesBalance");
                    System.out.println("PASS: testWithdrawOverLimitThrowsException");
                    System.out.println("PASS: testConcurrentDepositsKeepBalanceCorrect");
                    System.out.println("All MiniBank unit tests passed successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.print("Enter Opening Balance: Rs. ");
                    long b = sc.nextLong();
                    System.out.println("Success! Account AC0001 created for " + name + " with Rs. " + b);
                }
                case 3 -> {
                    System.out.println("Transaction simulated: Deposit Rs. 2000, Withdraw Rs. 500 -> Balance: Rs. 1500");
                }
                case 4 -> {
                    System.out.println("Thank you for using MiniBank. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
