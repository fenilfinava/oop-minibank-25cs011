// MiniProject - Module 3: Account Model & Interactive Driver
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String ownerName;
    private long balance;

    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public synchronized long getBalance() { return balance; }

    public synchronized void deposit(long amt) {
        this.balance += amt;
        System.out.println("  [Deposit] Account " + accountNumber + " credited with Rs. " + amt + ". New Balance: Rs. " + balance);
    }

    public synchronized boolean withdraw(long amt) {
        if (balance < amt) {
            System.out.println("  [Withdrawal Denied] Insufficient balance in " + accountNumber + " (Available: Rs. " + balance + ")");
            return false;
        }
        balance -= amt;
        System.out.println("  [Withdrawal] Account " + accountNumber + " debited with Rs. " + amt + ". Remaining Balance: Rs. " + balance);
        return true;
    }

    @Override
    public String toString() {
        return accountNumber + " | Owner: " + ownerName + " | Balance: Rs. " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        System.out.println("====================================================");
        System.out.println("  Module 3: Core Business Logic & Bank Service Layer");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");

        Account acc1 = new Account("AC1001", "Fenil Finava", 10000);
        Account acc2 = new Account("AC1002", "Raj Patel", 5000);
        service.openAccount(acc1);
        service.openAccount(acc2);

        System.out.print("\nEnter amount to deposit into AC1001 (e.g. 5000): Rs. ");
        long dep = sc.nextLong();
        service.deposit("AC1001", dep);

        System.out.print("Enter amount to withdraw from AC1001 (e.g. 2000): Rs. ");
        long wth = sc.nextLong();
        service.withdraw("AC1001", wth);

        System.out.print("Enter transfer amount from AC1001 to AC1002 (e.g. 3000): Rs. ");
        long trf = sc.nextLong();
        service.transfer("AC1001", "AC1002", trf);

        System.out.println("\n--- Generating Account Statement for AC1001 ---");
        service.printStatement("AC1001");

        service.listAll();
    }
}
