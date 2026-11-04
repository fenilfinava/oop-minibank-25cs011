// MiniProject - Module 2: Domain Model & Account Class Hierarchy
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.Scanner;

public abstract class Account implements Comparable<Account> {
    private static int nextId = 1000;
    protected String accountNumber;
    protected String ownerName;
    protected long balance;

    public Account(String ownerName, long balance) {
        this.accountNumber = "AC" + (++nextId);
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public synchronized long getBalance() { return balance; }

    public synchronized void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive (" + amount + ")");
            return;
        }
        this.balance += amount;
        System.out.println("Deposit of Rs. " + amount + " applied. Updated balance: Rs. " + balance);
    }

    public abstract boolean withdraw(long amount);

    @Override
    public int compareTo(Account other) {
        return Long.compare(this.balance, other.balance);
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "] Account No: " + accountNumber + 
               " | Owner: " + ownerName + " | Balance: Rs. " + balance;
    }

    // Direct runner for VS Code Code-Runner on Account.java
    public static void main(String[] args) {
        Main.main(args);
    }
}
