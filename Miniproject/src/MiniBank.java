public class MiniBank {
    public static void main(String[] args) {
        Account a1 = new Account("Alice", 5000);
        Account a2 = new Account("Bob", 2000);

        System.out.println("Account 1: " + a1);
        System.out.println("Account 2: " + a2);

        System.out.println("a1 equals a2: " + a1.equals(a2));

        Object obj = a1;
        if (obj instanceof Account) {
            System.out.println("obj is an instance of Account: " + ((Account) obj).getOwnerName());
        }

        Customer c = new Customer("Alice", "alice@test.com", "9876543210");
        c.setAddress(new Customer.Address("123 MG Road", "Ahmedabad", "380001"));
        Customer copy = c.clone();
        System.out.println("Cloned Customer: " + copy.getName() + ", Address: " + copy.getAddress());
    }
}
