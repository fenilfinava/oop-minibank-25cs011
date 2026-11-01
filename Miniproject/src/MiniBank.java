import java.util.Scanner;

public class MiniBank {
    record BankInfo(String name, String branch) {}

    enum MenuOption {
        OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT
    }

    public static void main(String[] args) {
        BankInfo info = new BankInfo("MiniBank", "Main Branch");
        System.out.println("=== " + info.name() + " (" + info.branch() + ") ===");

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> System.out.println("Open Account - to be implemented in a later lab");
                case 2 -> System.out.println("Deposit - to be implemented in a later lab");
                case 3 -> System.out.println("Withdraw - to be implemented in a later lab");
                case 4 -> System.out.println("Transfer - to be implemented in a later lab");
                case 5 -> {
                    System.out.println("Thank you for using MiniBank. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }
    }
}
