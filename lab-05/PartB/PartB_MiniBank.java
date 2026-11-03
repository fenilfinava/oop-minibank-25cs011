// Practical 5 - Part B: Account Hierarchy (Savings, Current, FD) (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class PartB_MiniBank {
    abstract static class Account {
        protected String accNo;
        protected long balance;

        public Account(String accNo, long balance) {
            this.accNo = accNo; this.balance = balance;
        }

        public abstract double interestRate();
        public abstract boolean canWithdraw(long amount);

        public void deposit(long amount) { balance += amount; }
        public boolean withdraw(long amount) {
            if (canWithdraw(amount)) { balance -= amount; return true; }
            return false;
        }
        public long getBalance() { return balance; }
        public String getAccNo() { return accNo; }
    }

    static class SavingsAccount extends Account {
        private long minBalance;
        public SavingsAccount(String accNo, long bal, long minBal) {
            super(accNo, bal); this.minBalance = minBal;
        }
        public double interestRate() { return 4.0; }
        public boolean canWithdraw(long amount) { return (balance - amount) >= minBalance; }
    }

    static class CurrentAccount extends Account {
        private long overdraftLimit;
        public CurrentAccount(String accNo, long bal, long limit) {
            super(accNo, bal); this.overdraftLimit = limit;
        }
        public double interestRate() { return 0.0; }
        public boolean canWithdraw(long amount) { return (balance - amount) >= -overdraftLimit; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 05: Account Hierarchy & Polymorphism ===");

        System.out.print("Enter Savings Account opening balance & Min Balance (e.g. 5000 1000): ");
        long sBal = sc.nextLong();
        long sMin = sc.nextLong();
        Account sa = new SavingsAccount("SA101", sBal, sMin);

        System.out.print("Enter Current Account opening balance & Overdraft Limit (e.g. 2000 5000): ");
        long cBal = sc.nextLong();
        long cLimit = sc.nextLong();
        Account ca = new CurrentAccount("CA201", cBal, cLimit);

        Account[] accounts = { sa, ca };
        System.out.println("\n--- Polymorphic Account Details ---");
        for (Account a : accounts) {
            System.out.println(a.getAccNo() + " (" + a.getClass().getSimpleName() + 
                               ") | Balance: Rs. " + a.getBalance() + 
                               " | Interest Rate: " + a.interestRate() + "%");
        }

        System.out.print("\nEnter withdrawal amount to test on Savings: Rs. ");
        long wAmt = sc.nextLong();
        boolean res = sa.withdraw(wAmt);
        System.out.println("Savings Withdrawal of Rs. " + wAmt + " -> Success: " + res + " (Balance: Rs. " + sa.getBalance() + ")");
    }
}
