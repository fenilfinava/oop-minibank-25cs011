// Practical 13 - Part B: Generic Repository<T> with Reflection @Id (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class PartB_MiniBank {
    static class Repository<T> {
        private HashMap<String, T> store = new HashMap<>();

        public void save(T entity) throws Exception {
            String key = null;
            for (Field f : entity.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                key = f.get(entity).toString();
                break;
            }
            store.put(key, entity);
            System.out.println("Saved entity in Generic Repository under key: " + key);
        }

        public T findById(String id) { return store.get(id); }
        public List<T> findAll() { return new ArrayList<>(store.values()); }
    }

    static class Account {
        String id;
        String owner;
        long balance;
        public Account(String id, String owner, long bal) {
            this.id = id; this.owner = owner; this.balance = bal;
        }
        public String toString() { return id + " (" + owner + "): Rs. " + balance; }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 13: Generic Repository<T> ===");

        Repository<Account> repo = new Repository<>();

        System.out.print("Enter Account ID to add (e.g. AC0001): ");
        String id = sc.next();
        System.out.print("Enter Owner Name: ");
        String name = sc.next();
        System.out.print("Enter Balance: Rs. ");
        long bal = sc.nextLong();

        repo.save(new Account(id, name, bal));

        System.out.print("\nEnter ID to lookup with findById: ");
        String query = sc.next();
        Account found = repo.findById(query);
        System.out.println("Lookup Result: " + (found != null ? found : "Account Not Found"));
    }
}
