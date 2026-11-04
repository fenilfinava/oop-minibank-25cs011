// MiniProject - Module 1: Main Application & Console UI Driver
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.ArrayList;
import java.util.Scanner;

public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        System.out.println("==========================================");
        System.out.println("     MiniBank - Main Branch");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Statement");
            System.out.println("6. List All Accounts");
            System.out.println("7. Run Unit Tests");
            System.out.println("8. Exit");
            System.out.print("Select an option (1-8): ");

            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Type (1: Savings, 2: Current): ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Owner Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Opening Balance: ");
                    long bal = sc.nextLong();
                    sc.nextLine();

                    Account acc;
                    if (type == 1) {
                        System.out.print("Enter Minimum Balance: ");
                        long minB = sc.nextLong();
                        sc.nextLine();
                        acc = new SavingsAccount(name, bal, minB);
                    } else {
                        System.out.print("Enter Overdraft Limit: ");
                        long od = sc.nextLong();
                        sc.nextLine();
                        acc = new CurrentAccount(name, bal, od);
                    }
                    service.openAccount(acc);
                    System.out.println("Account opened successfully! Assigned Account Number: " + acc.getAccountNumber());
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    long amt = sc.nextLong();
                    sc.nextLine();
                    service.deposit(accNo, amt);
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    long amt = sc.nextLong();
                    sc.nextLine();
                    service.withdraw(accNo, amt);
                }
                case 4 -> {
                    System.out.print("Enter Source Account Number: ");
                    String from = sc.nextLine();
                    System.out.print("Enter Destination Account Number: ");
                    String to = sc.nextLine();
                    System.out.print("Enter Transfer Amount: ");
                    long amt = sc.nextLong();
                    sc.nextLine();
                    service.transfer(from, to, amt);
                }
                case 5 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    service.printStatement(accNo);
                }
                case 6 -> service.listAccounts();
                case 7 -> BankTests.runAll();
                case 8 -> {
                    System.out.println("State saved successfully.");
                    System.out.println("Thank you for choosing MiniBank. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid selection. Please choose 1 to 8.");
            }
        }
    }
}
