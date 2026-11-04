// MiniProject - Module 4: Interactive Generic Repository Driver
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repository<AccountEntity> repo = new Repository<>();

        System.out.println("====================================================");
        System.out.println("  Module 4: Generic Repository Pattern with Reflection");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");

        System.out.println("\n[Saving entities into Repository<AccountEntity>]");
        AccountEntity a1 = new AccountEntity("AC1001", "Fenil Finava", 15000);
        AccountEntity a2 = new AccountEntity("AC1002", "Raj Patel", 25000);
        AccountEntity a3 = new AccountEntity("AC1003", "Karan Shah", 50000);
        repo.save(a1);
        repo.save(a2);
        repo.save(a3);

        System.out.print("\nEnter Account ID to search using findById() (e.g. AC1001): ");
        String searchId = sc.nextLine().trim();

        AccountEntity found = repo.findById(searchId);
        if (found != null) {
            System.out.println("Search Result Found: " + found);
        } else {
            System.out.println("No account found with ID: " + searchId);
        }

        System.out.println("\nAll Stored Entities in Generic Repository (Total: " + repo.count() + "):");
        for (AccountEntity acc : repo.findAll()) {
            System.out.println("  " + acc);
        }
    }
}
