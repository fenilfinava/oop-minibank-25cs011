import model.Account;
import model.Customer;
import model.SavingsAccount;
import repository.Repository;

public class MiniBank {
    public static void main(String[] args) {
        Repository<Account> accRepo = new Repository<>();
        Account a1 = new SavingsAccount("Alice", 10000, 1000);
        Account a2 = new SavingsAccount("Bob", 8000, 1000);
        Account a3 = new SavingsAccount("Charlie", 15000, 1000);

        accRepo.saveAll(a1, a2, a3);

        System.out.println("findById: " + accRepo.findById(a2.getAccountNumber()));
        System.out.println("findAll total accounts: " + accRepo.findAll().size());

        Repository<Customer> custRepo = new Repository<>();
        Customer c1 = new Customer("Fenil", "fenil@test.com", "9876543210");
        custRepo.save(c1);
        System.out.println("Found customer by id: " + custRepo.findById(c1.getCustomerId()));

        Long[] balances = { a1.getBalance(), a2.getBalance(), a3.getBalance() };
        System.out.println("Average balance: Rs. " + Repository.average(balances));
    }
}
