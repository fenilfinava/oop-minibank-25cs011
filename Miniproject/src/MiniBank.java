import java.util.ArrayList;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import service.AccountStore;

public class MiniBank {
    public static void main(String[] args) {
        AccountStore store = new AccountStore();

        SavingsAccount a1 = new SavingsAccount("User1", 5000, 500);
        SavingsAccount a2 = new SavingsAccount("User2", 2000, 500);
        CurrentAccount a3 = new CurrentAccount("User3", 9000, 1000);

        store.add(a1);
        store.add(a2);
        store.add(a3);

        System.out.println("Lookup by account number: " + store.get(a2.getAccountNumber()));

        System.out.println("Accounts sorted by balance (highest first):");
        ArrayList<Account> sorted = store.sortedByBalance();
        for (Account a : sorted) {
            System.out.println("  " + a.getAccountNumber() + " (" + a.getOwnerName() + ") -> Rs. " + a.getBalance());
        }
    }
}
