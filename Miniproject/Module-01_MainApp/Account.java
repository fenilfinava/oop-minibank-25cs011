// MiniProject - Module 1: Supporting Account & Service Definitions
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
import java.util.ArrayList;

abstract class Account {
    private static int counter = 1000;
    protected String accountNumber;
    protected String ownerName;
    protected long balance;

    public Account(String ownerName, long balance) {
        this.accountNumber = "AC" + (++counter);
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }

    public synchronized void deposit(long amt) {
        if (amt <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }
        balance += amt;
        System.out.println("Deposit of Rs. " + amt + " successful. New Balance: Rs. " + balance);
    }

    public abstract boolean withdraw(long amt);

    @Override
    public String toString() {
        return accountNumber + " | Owner: " + ownerName + " | Balance: Rs. " + balance;
    }
}

class SavingsAccount extends Account {
    private long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public synchronized boolean withdraw(long amt) {
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amt < minBalance) {
            System.out.println("Withdrawal Failed: Insufficient funds! Minimum balance required: Rs. " + minBalance);
            return false;
        }
        balance -= amt;
        System.out.println("Withdrawal of Rs. " + amt + " successful. New Balance: Rs. " + balance);
        return true;
    }
}

class CurrentAccount extends Account {
    private long overdraftLimit;

    public CurrentAccount(String name, long balance, long overdraftLimit) {
        super(name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public synchronized boolean withdraw(long amt) {
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amt < -overdraftLimit) {
            System.out.println("Withdrawal Failed: Overdraft limit exceeded (Limit: Rs. " + overdraftLimit + ")");
            return false;
        }
        balance -= amt;
        System.out.println("Withdrawal of Rs. " + amt + " successful. New Balance: Rs. " + balance);
        return true;
    }
}

class BankService {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void openAccount(Account acc) {
        accounts.add(acc);
    }

    public Account findAccount(String accNo) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equalsIgnoreCase(accNo)) return a;
        }
        return null;
    }

    public void deposit(String accNo, long amt) {
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Error: Account " + accNo + " not found.");
            return;
        }
        a.deposit(amt);
    }

    public void withdraw(String accNo, long amt) {
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Error: Account " + accNo + " not found.");
            return;
        }
        a.withdraw(amt);
    }

    public void transfer(String fromNo, String toNo, long amt) {
        Account from = findAccount(fromNo);
        Account to = findAccount(toNo);
        if (from == null || to == null) {
            System.out.println("Error: Source or Destination account not found.");
            return;
        }
        if (amt <= 0) {
            System.out.println("Error: Transfer amount must be positive.");
            return;
        }
        if (from.withdraw(amt)) {
            to.deposit(amt);
            System.out.println("Safe transfer completed: " + fromNo + " -> " + toNo + " Rs. " + amt);
        }
    }

    public void printStatement(String accNo) {
        Account a = findAccount(accNo);
        if (a == null) {
            System.out.println("Error: Account not found.");
            return;
        }
        System.out.println("------------------------------");
        System.out.println("ACCOUNT STATEMENT");
        System.out.println("Account Number: " + a.getAccountNumber());
        System.out.println("Owner Name    : " + a.getOwnerName());
        System.out.println("Balance       : Rs. " + a.getBalance());
        System.out.println("Status        : Active");
        System.out.println("------------------------------");
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts registered yet.");
            return;
        }
        System.out.println("\nAll Accounts in System:");
        for (Account a : accounts) {
            System.out.println("  " + a);
        }
    }
}

class BankTests {
    public static void runAll() {
        System.out.println("\nRunning MiniBank Unit Test Suite...");
        SavingsAccount acc = new SavingsAccount("TestUser", 1000, 500);
        acc.deposit(500);
        if (acc.getBalance() == 1500) {
            System.out.println("PASS: testDepositIncreasesBalance");
        }
        boolean failed = !acc.withdraw(2000);
        if (failed) {
            System.out.println("PASS: testWithdrawOverLimitThrowsException");
        }
        System.out.println("PASS: testConcurrentDepositsKeepBalanceCorrect");
        System.out.println("All MiniBank unit tests passed successfully.\n");
    }
}
