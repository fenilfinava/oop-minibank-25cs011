// MiniProject - Module 2: Interactive Domain Model Driver
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("  Module 2: Domain Model & Account Class Hierarchy");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");

        System.out.println("\n[1] Creating Savings Account:");
        System.out.print("Enter Owner Name (e.g. Fenil Finava): ");
        String name1 = sc.nextLine();
        System.out.print("Enter Opening Balance (e.g. 10000): ");
        long bal1 = sc.nextLong();
        System.out.print("Enter Minimum Balance (e.g. 1000): ");
        long minB = sc.nextLong();
        sc.nextLine();

        Account acc1 = new SavingsAccount(name1, bal1, minB);
        System.out.println("Created: " + acc1);

        System.out.println("\n[2] Creating Current Account:");
        System.out.print("Enter Owner Name (e.g. Raj Patel): ");
        String name2 = sc.nextLine();
        System.out.print("Enter Opening Balance (e.g. 5000): ");
        long bal2 = sc.nextLong();
        System.out.print("Enter Overdraft Limit (e.g. 2000): ");
        long od = sc.nextLong();
        sc.nextLine();

        Account acc2 = new CurrentAccount(name2, bal2, od);
        System.out.println("Created: " + acc2);

        System.out.println("\n[3] Testing Polymorphic Withdrawals:");
        System.out.print("Enter amount to withdraw from Savings (" + acc1.getAccountNumber() + "): Rs. ");
        long w1 = sc.nextLong();
        acc1.withdraw(w1);

        System.out.print("Enter amount to withdraw from Current (" + acc2.getAccountNumber() + "): Rs. ");
        long w2 = sc.nextLong();
        acc2.withdraw(w2);

        System.out.println("\n====================================================");
        System.out.println("Summary of Instantiated Accounts:");
        System.out.println("  " + acc1);
        System.out.println("  " + acc2);
        System.out.println("====================================================");
    }
}
