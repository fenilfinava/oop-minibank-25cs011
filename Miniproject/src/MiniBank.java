import exception.BankException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import model.Account;
import model.BankInfo;
import model.CurrentAccount;
import model.FixedDepositAccount;
import model.SavingsAccount;
import service.BankService;
import service.BankTests;
import util.Validator;

public class MiniBank {
    public static void main(String[] args) {
        BankInfo info = new BankInfo("MiniBank", "Main Branch");
        System.out.println("==========================================");
        System.out.println("     " + info.name() + " - " + info.branch());
        System.out.println("==========================================");

        if (args.length > 0 && args[0].equals("--test")) {
            BankTests.runAll();
            return;
        }

        BankService service = new BankService();
        Path dataPath = Path.of("data/accounts.dat");
        Path logsDir = Path.of("logs");
        Path reportFile = Path.of("reports/daily_report.txt");

        if (Files.exists(dataPath)) {
            try {
                service.loadAccounts(dataPath);
                System.out.println("Loaded saved accounts from " + dataPath);
            } catch (Exception e) {
                System.out.println("Could not load existing data: " + e.getMessage());
            }
        }

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Statement");
            System.out.println("6. List All Accounts");
            System.out.println("7. Generate Summary Report");
            System.out.println("8. Run Unit Tests");
            System.out.println("9. Exit");
            System.out.print("Select an option (1-9): ");

            if (!sc.hasNextInt()) {
                break;
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Type (1: Savings, 2: Current, 3: Fixed Deposit): ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Owner Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Opening Balance: ");
                    long bal = sc.nextLong();
                    sc.nextLine();

                    Account acc = switch (type) {
                        case 1 -> {
                            System.out.print("Enter Minimum Balance: ");
                            long minB = sc.nextLong();
                            sc.nextLine();
                            yield new SavingsAccount(name, bal, minB);
                        }
                        case 2 -> {
                            System.out.print("Enter Overdraft Limit: ");
                            long od = sc.nextLong();
                            sc.nextLine();
                            yield new CurrentAccount(name, bal, od);
                        }
                        default -> new FixedDepositAccount(name, bal);
                    };

                    service.openAccount(acc);
                    System.out.println("Account opened successfully! Assigned Account Number: " + acc.getAccountNumber());
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    long amt = sc.nextLong();
                    sc.nextLine();
                    try {
                        service.deposit(accNo, amt);
                        System.out.println("Deposit of Rs. " + amt + " successful.");
                    } catch (BankException e) {
                        System.out.println("Deposit Failed: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    long amt = sc.nextLong();
                    sc.nextLine();
                    try {
                        service.withdraw(accNo, amt);
                        System.out.println("Withdrawal of Rs. " + amt + " successful.");
                    } catch (BankException e) {
                        System.out.println("Withdrawal Failed: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Enter Source Account Number: ");
                    String from = sc.nextLine();
                    System.out.print("Enter Destination Account Number: ");
                    String to = sc.nextLine();
                    System.out.print("Enter Transfer Amount: ");
                    long amt = sc.nextLong();
                    sc.nextLine();
                    try {
                        service.transfer(from, to, amt);
                        System.out.println("Transfer of Rs. " + amt + " completed.");
                    } catch (BankException e) {
                        System.out.println("Transfer Failed: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    try {
                        System.out.print(service.statement(accNo));
                    } catch (BankException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 6 -> {
                    ArrayList<Account> list = service.listAccounts();
                    if (list.isEmpty()) {
                        System.out.println("No accounts registered yet.");
                    } else {
                        System.out.println("\nAll Accounts (Sorted by Balance):");
                        for (Account a : list) {
                            System.out.println("  " + a);
                        }
                    }
                }
                case 7 -> {
                    try {
                        service.generateReport(logsDir, reportFile);
                        if (Files.exists(reportFile)) {
                            System.out.print(Files.readString(reportFile));
                        } else {
                            System.out.println("No logs available yet to generate report.");
                        }
                    } catch (Exception e) {
                        System.out.println("Report generation error: " + e.getMessage());
                    }
                }
                case 8 -> BankTests.runAll();
                case 9 -> {
                    try {
                        service.saveAccounts(dataPath);
                        System.out.println("Saved accounts state to " + dataPath);
                    } catch (Exception e) {
                        System.out.println("Error saving accounts: " + e.getMessage());
                    }
                    System.out.println("Thank you for choosing MiniBank. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid selection. Please choose 1 to 9.");
            }
        }
    }
}
