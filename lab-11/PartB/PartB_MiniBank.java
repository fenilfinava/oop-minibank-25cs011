// Practical 11 - Part B: State Persistence & TransactionLog (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class PartB_MiniBank {
    static class Account implements Serializable {
        private static final long serialVersionUID = 1L;
        String accNo;
        String owner;
        long balance;
        public Account(String accNo, String owner, long balance) {
            this.accNo = accNo; this.owner = owner; this.balance = balance;
        }
        public String toString() { return accNo + " (" + owner + "): Rs. " + balance; }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 11: File Persistence & Transaction Log ===");

        System.out.print("Enter Account Number to save: ");
        String no = sc.next();
        System.out.print("Enter Account Owner Name: ");
        String name = sc.next();
        System.out.print("Enter Balance: Rs. ");
        long bal = sc.nextLong();

        Account acc = new Account(no, name, bal);
        Path datFile = Paths.get("accounts_test.dat");
        Path logFile = Paths.get("transactions_test.log");

        // Save binary state
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(datFile))) {
            oos.writeObject(acc);
            System.out.println("Account state persisted to " + datFile.getFileName());
        }

        // Append text log
        String logEntry = "CREATED " + acc.accNo + " AMOUNT " + acc.balance + "\n";
        Files.writeString(logFile, logEntry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println("Transaction logged to " + logFile.getFileName());

        // Reload state
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(datFile))) {
            Account restored = (Account) ois.readObject();
            System.out.println("\nReloaded from Disk: " + restored);
        }

        Files.deleteIfExists(datFile);
        Files.deleteIfExists(logFile);
    }
}
