// Practical 12 - Part B: AccountStore & Comparator Sorting (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class PartB_MiniBank {
    static class Account {
        String accNo;
        String name;
        long balance;
        public Account(String accNo, String name, long bal) {
            this.accNo = accNo; this.name = name; this.balance = bal;
        }
        public long getBalance() { return balance; }
        public String toString() { return accNo + " | " + name + " | Rs. " + balance; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 12: AccountStore & Sorting ===");

        HashMap<String, Account> store = new HashMap<>();

        System.out.print("How many accounts to register? (e.g. 3): ");
        int count = sc.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter Account " + i + " (AccNo Name Balance): ");
            String no = sc.next();
            String name = sc.next();
            long bal = sc.nextLong();
            store.put(no, new Account(no, name, bal));
        }

        System.out.println("\nStore holds " + store.size() + " accounts in HashMap.");

        ArrayList<Account> sortedList = new ArrayList<>(store.values());
        sortedList.sort(Comparator.comparingLong(Account::getBalance).reversed());

        System.out.println("\n--- Accounts Sorted by Balance (Highest First) ---");
        for (Account a : sortedList) {
            System.out.println("  " + a);
        }
    }
}
