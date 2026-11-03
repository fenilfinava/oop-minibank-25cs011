// Practical 3 - Part B: Account Identity, equals/hashCode & Address (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.Objects;

public class PartB_MiniBank {
    static class Address {
        private String line, city, pincode;
        public Address(String line, String city, String pincode) {
            this.line = line; this.city = city; this.pincode = pincode;
        }
        public String toString() { return line + ", " + city + " - " + pincode; }
    }

    static class Account {
        private final String accountNumber;
        private String ownerName;
        private long balance;

        public Account(String accountNumber, String ownerName, long balance) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account[" + accountNumber + ", Owner: " + ownerName + ", Balance: Rs. " + balance + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Account)) return false;
            Account acc = (Account) o;
            return Objects.equals(accountNumber, acc.accountNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(accountNumber);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 03: Account Identity & Address ===");

        System.out.print("Enter Account 1 Number (e.g. AC0001): ");
        String a1Num = sc.next();
        System.out.print("Enter Account 1 Owner Name: ");
        String a1Name = sc.next();
        System.out.print("Enter Account 1 Balance: ");
        long a1Bal = sc.nextLong();
        Account acc1 = new Account(a1Num, a1Name, a1Bal);

        System.out.print("\nEnter Account 2 Number: ");
        String a2Num = sc.next();
        System.out.print("Enter Account 2 Owner Name: ");
        String a2Name = sc.next();
        System.out.print("Enter Account 2 Balance: ");
        long a2Bal = sc.nextLong();
        Account acc2 = new Account(a2Num, a2Name, a2Bal);

        sc.nextLine(); // clear buffer
        System.out.print("\nEnter Customer Address (Street): ");
        String street = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Pincode: ");
        String pin = sc.nextLine();
        Address addr = new Address(street, city, pin);

        System.out.println("\n--- Evaluation Results ---");
        System.out.println("Account 1: " + acc1);
        System.out.println("Account 2: " + acc2);
        System.out.println("Customer Address: " + addr);
        System.out.println("acc1.equals(acc2): " + acc1.equals(acc2));
        System.out.println("acc1.hashCode() == acc2.hashCode(): " + (acc1.hashCode() == acc2.hashCode()));
    }
}
