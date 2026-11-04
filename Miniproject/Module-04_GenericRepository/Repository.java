// MiniProject - Module 4: Generic Repository with Reflection
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {
}

class AccountEntity {
    @Id
    private String id;
    private String owner;
    private long balance;

    public AccountEntity(String id, String owner, long balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() { return id; }
    public String getOwner() { return owner; }
    public long getBalance() { return balance; }

    @Override
    public String toString() {
        return "AccountEntity[ID=" + id + ", Owner=" + owner + ", Balance=Rs. " + balance + "]";
    }
}

public class Repository<T> {
    private Map<String, T> storage = new HashMap<>();

    public void save(T entity) {
        String key = extractId(entity);
        storage.put(key, entity);
        System.out.println("  [Repository] Saved entity under discovered @Id key: '" + key + "'");
    }

    public T findById(String id) {
        return storage.get(id);
    }

    public ArrayList<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public int count() {
        return storage.size();
    }

    private String extractId(T entity) {
        Class<?> clazz = entity.getClass();
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Id.class)) {
                f.setAccessible(true);
                try {
                    Object val = f.get(entity);
                    return val != null ? val.toString() : "UNKNOWN";
                } catch (Exception e) {
                    throw new RuntimeException("Error accessing @Id field", e);
                }
            }
        }
        return entity.toString();
    }

    public static void main(String[] args) {
        Main.main(args);
    }
}
