public class MiniBank {
    record BankInfo(String name, String branch) {}

    public static void main(String[] args) {
        BankInfo info = new BankInfo("MiniBank", "Main Branch");
        System.out.println("=== " + info.name() + " (" + info.branch() + ") ===");

        Account[] accounts = new Account[3];
        accounts[0] = new Account("Alice", 5000);
        accounts[1] = new Account("Bob", 2000);
        accounts[2] = new Account("Charlie");

        accounts[0].deposit(2000);
        System.out.println("Alice balance after deposit: " + accounts[0].getBalance());

        boolean ok = accounts[0].withdraw(3000);
        System.out.println("Alice withdraw 3000 success: " + ok + ", balance: " + accounts[0].getBalance());

        boolean fail = accounts[0].withdraw(10000);
        System.out.println("Alice withdraw 10000 success: " + fail + ", balance: " + accounts[0].getBalance());
    }
}
