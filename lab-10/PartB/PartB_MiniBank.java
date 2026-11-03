// Practical 10 - Part B: Deadlock-Free Inter-Account Transfer (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class PartB_MiniBank {
    static class Account {
        private String accNo;
        private long balance;
        public Account(String accNo, long bal) { this.accNo = accNo; this.balance = bal; }
        public String getAccNo() { return accNo; }
        public long getBalance() { return balance; }
        public void debit(long amt) { balance -= amt; }
        public void credit(long amt) { balance += amt; }
    }

    public static void transfer(Account from, Account to, long amount) {
        // Enforce strict lock ordering based on Account Number to avoid circular deadlock!
        Account firstLock = from.getAccNo().compareTo(to.getAccNo()) < 0 ? from : to;
        Account secondLock = (firstLock == from) ? to : from;

        synchronized (firstLock) {
            System.out.println("[Lock Acquired] First lock: " + firstLock.getAccNo());
            synchronized (secondLock) {
                System.out.println("[Lock Acquired] Second lock: " + secondLock.getAccNo());
                if (from.getBalance() >= amount) {
                    from.debit(amount);
                    to.credit(amount);
                    System.out.println("Transferred Rs. " + amount + " from " + from.getAccNo() + " to " + to.getAccNo());
                } else {
                    System.out.println("Transfer failed! Insufficient funds in " + from.getAccNo());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 10: Deadlock-Free Inter-Account Transfer ===");

        Account a1 = new Account("AC0001", 10000);
        Account a2 = new Account("AC0002", 5000);

        System.out.println("Initial -> " + a1.getAccNo() + ": Rs. " + a1.getBalance() + " | " + a2.getAccNo() + ": Rs. " + a2.getBalance());
        System.out.print("Enter amount to transfer from AC0001 to AC0002: Rs. ");
        long amt = sc.nextLong();

        transfer(a1, a2, amt);
        System.out.println("Final -> " + a1.getAccNo() + ": Rs. " + a1.getBalance() + " | " + a2.getAccNo() + ": Rs. " + a2.getBalance());
    }
}
