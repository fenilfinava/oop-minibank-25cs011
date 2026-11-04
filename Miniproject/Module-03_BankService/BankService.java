// MiniProject - Module 3: Core Business Logic & Bank Service Layer
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BankService {
    private ArrayList<Account> accountList = new ArrayList<>();

    public void openAccount(Account acc) {
        accountList.add(acc);
        System.out.println("Account registered in BankService: " + acc.getAccountNumber());
    }

    public Account findAccount(String accNo) {
        for (Account a : accountList) {
            if (a.getAccountNumber().equalsIgnoreCase(accNo)) return a;
        }
        return null;
    }

    public boolean deposit(String accNo, long amount) {
        Account acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("Error: Account " + accNo + " not found!");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive (" + amount + ")");
            return false;
        }
        acc.deposit(amount);
        return true;
    }

    public boolean withdraw(String accNo, long amount) {
        Account acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("Error: Account " + accNo + " not found!");
            return false;
        }
        return acc.withdraw(amount);
    }

    // Deadlock-free ordered lock transfer
    public boolean transfer(String fromAccNo, String toAccNo, long amount) {
        Account from = findAccount(fromAccNo);
        Account to = findAccount(toAccNo);
        if (from == null || to == null) {
            System.out.println("Error: Invalid source or destination account!");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be positive.");
            return false;
        }

        // Ordered locking by Account Number to prevent Deadlock
        Account firstLock = from.getAccountNumber().compareTo(to.getAccountNumber()) < 0 ? from : to;
        Account secondLock = (firstLock == from) ? to : from;

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println("Deadlock-Free Transfer Success: " + fromAccNo + " -> " + toAccNo + " Rs. " + amount);
                    return true;
                } else {
                    System.out.println("Transfer Failed: Source account could not fulfill withdrawal.");
                    return false;
                }
            }
        }
    }

    public void printStatement(String accNo) {
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Error: Account not found!");
            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("           OFFICIAL BANK STATEMENT      ");
        System.out.println("Account Number : " + a.getAccountNumber());
        System.out.println("Account Holder : " + a.getOwnerName());
        System.out.println("Current Balance: Rs. " + a.getBalance());
        System.out.println("Status         : VERIFIED & ACTIVE");
        System.out.println("----------------------------------------");
    }

    public void listAll() {
        if (accountList.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("\nAll Registered Accounts (Sorted by Balance):");
        accountList.sort(Comparator.comparingLong(Account::getBalance).reversed());
        for (Account a : accountList) {
            System.out.println("  " + a);
        }
    }

    public static void main(String[] args) {
        Main.main(args);
    }
}
