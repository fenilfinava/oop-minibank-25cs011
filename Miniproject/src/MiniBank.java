public class MiniBank {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("Alice", 10000, 1000),
            new CurrentAccount("Bob", 5000, 2000),
            new FixedDepositAccount("Charlie", 50000)
        };

        for (Account a : accounts) {
            System.out.println(a.getAccountNumber() + " (" + a.getOwnerName() + ") Interest Rate: " + a.interestRate() + "%");
            if (a instanceof SavingsAccount sa) {
                System.out.println("  Min Balance required: Rs. " + sa.getMinBalance());
            } else if (a instanceof CurrentAccount ca) {
                System.out.println("  Overdraft Limit: Rs. " + ca.getOverdraftLimit());
            } else if (a instanceof FixedDepositAccount) {
                System.out.println("  Fixed deposit locked until maturity.");
            }
        }
    }
}
