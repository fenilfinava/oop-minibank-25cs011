// Practical 7 - Part B: Custom Annotations & Reflection Validator (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.lang.annotation.*;
import java.lang.reflect.Field;

public class PartB_MiniBank {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Id {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Positive { String message() default "must be greater than 0"; }

    static class BankAccount {
        @Id
        private String accNumber;

        @Positive(message = "Account balance cannot be negative")
        private long balance;

        public BankAccount(String accNumber, long balance) {
            this.accNumber = accNumber;
            this.balance = balance;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 07: Reflection Annotation Validator ===");

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        System.out.print("Enter Account Balance (try negative value to test validation): ");
        long bal = sc.nextLong();

        BankAccount acc = new BankAccount(accNo, bal);

        System.out.println("\n--- Running Reflection Validator ---");
        boolean valid = true;
        for (Field f : acc.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Id.class)) {
                System.out.println("Found @Id on field: '" + f.getName() + "' -> Value: " + f.get(acc));
            }
            if (f.isAnnotationPresent(Positive.class)) {
                Positive p = f.getAnnotation(Positive.class);
                long val = (long) f.get(acc);
                if (val <= 0) {
                    System.out.println("Validation Error on '" + f.getName() + "': " + p.message() + " (Found: " + val + ")");
                    valid = false;
                }
            }
        }
        if (valid) {
            System.out.println("Result: Entity passed all annotation checks successfully!");
        }
    }
}
