// Practical 2 - Part B: MiniBank Customer and Account Domain Model (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class PartB_MiniBank {
    static class Customer {
        private String name;
        private String email;
        private String mobile;
        private final String customerId;
        private static long customerCounter = 100;

        public Customer(String name, String email, String mobile) {
            this.customerId = "CUST" + (++customerCounter);
            this.name = name;
            this.email = email;
            this.mobile = mobile;
        }

        public String getCustomerId() { return customerId; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getMobile() { return mobile; }
    }

    static class Account {
        private final String accountNumber;
        private String ownerName;
        private long balance;
        private boolean active;
        private static long accountCounter = 0;

        public Account(String ownerName, long openingBalance) {
            this.accountNumber = String.format("AC%04d", ++accountCounter);
            this.ownerName = ownerName;
            this.balance = openingBalance;
            this.active = true;
        }

        public boolean deposit(long amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }

        public boolean withdraw(long amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public String getAccountNumber() { return accountNumber; }
        public String getOwnerName() { return ownerName; }
        public long getBalance() { return balance; }
        public boolean isActive() { return active; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 02: Account Creation & Operations ===");
        
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Customer Mobile: ");
        String mobile = sc.nextLine();

        Customer cust = new Customer(name, email, mobile);
        System.out.println("Customer registered: " + cust.getName() + " with ID: " + cust.getCustomerId());

        System.out.print("Enter opening balance for Account (Rs): ");
        long openBal = sc.nextLong();
        Account acc = new Account(cust.getName(), openBal);
        System.out.println("Account created successfully! Account No: " + acc.getAccountNumber() + " | Balance: Rs. " + acc.getBalance());

        boolean running = true;
        while (running) {
            System.out.println("\n1. Deposit Money  2. Withdraw Money  3. Check Balance  4. Exit");
            System.out.print("Enter option (1-4): ");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("Enter deposit amount: Rs. ");
                    long amt = sc.nextLong();
                    if (acc.deposit(amt)) {
                        System.out.println("Deposit successful! New Balance: Rs. " + acc.getBalance());
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: Rs. ");
                    long amt = sc.nextLong();
                    if (acc.withdraw(amt)) {
                        System.out.println("Withdrawal successful! Remaining Balance: Rs. " + acc.getBalance());
                    } else {
                        System.out.println("Withdrawal Failed! Insufficient funds. Available: Rs. " + acc.getBalance());
                    }
                }
                case 3 -> System.out.println("Account: " + acc.getAccountNumber() + " | Owner: " + acc.getOwnerName() + " | Balance: Rs. " + acc.getBalance());
                case 4 -> {
                    System.out.println("Exiting Lab 02 MiniBank. Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
