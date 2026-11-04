// MiniProject - Module 5: Custom Annotations & Reflection Validator
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Positive {
    String message() default "must be greater than zero";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
    String message() default "exceeds maximum allowed length";
}

class CustomerAccount {
    @Id
    private String accountNumber;

    @MaxLength(value = 15, message = "Owner name length cannot exceed 15 characters")
    private String ownerName;

    @Positive(message = "Account balance must be positive (> 0)")
    private long balance;

    public CustomerAccount(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
}

public class AnnotationValidator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object val = f.get(obj);

                // Check @Positive annotation
                if (f.isAnnotationPresent(Positive.class)) {
                    Positive ann = f.getAnnotation(Positive.class);
                    if (val instanceof Number num && num.doubleValue() <= 0) {
                        errors.add("Validation Violation on field '" + f.getName() + "': Value (" + val + ") " + ann.message());
                    }
                }

                // Check @MaxLength annotation
                if (f.isAnnotationPresent(MaxLength.class)) {
                    MaxLength ann = f.getAnnotation(MaxLength.class);
                    if (val != null && val.toString().length() > ann.value()) {
                        errors.add("Validation Violation on field '" + f.getName() + "': Length (" + val.toString().length() + ") " + ann.message() + " (Max: " + ann.value() + ")");
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Reflection access error on field: " + f.getName());
            }
        }
        return errors;
    }

    public static void main(String[] args) {
        Main.main(args);
    }
}
