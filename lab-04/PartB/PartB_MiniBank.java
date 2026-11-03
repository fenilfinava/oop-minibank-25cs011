// Practical 4 - Part B: Input Validation & Command Parser (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.regex.Pattern;

public class PartB_MiniBank {
    public static boolean isValidMobile(String m) {
        return m != null && Pattern.matches("^[6-9]\\d{9}$", m);
    }

    public static boolean isValidPan(String pan) {
        return pan != null && Pattern.matches("^[A-Z]{5}[0-9]{4}[A-Z]$", pan);
    }

    public static boolean isValidEmail(String email) {
        return email != null && Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email);
    }

    record Command(String action, String accountNo, long amount) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MiniBank Lab 04: Regex Validation & Command Parser ===");

        System.out.print("Enter Mobile Number: ");
        String mob = sc.nextLine();
        System.out.println("Mobile Valid: " + isValidMobile(mob));

        System.out.print("Enter PAN Card Number: ");
        String pan = sc.nextLine().toUpperCase();
        System.out.println("PAN Valid: " + isValidPan(pan));

        System.out.print("Enter Email Address: ");
        String email = sc.nextLine();
        System.out.println("Email Valid: " + isValidEmail(email));

        System.out.println("\n--- Testing Command Parser ---");
        System.out.print("Enter banking command (e.g. DEPOSIT AC0001 500): ");
        String cmdLine = sc.nextLine().trim();
        String[] parts = cmdLine.split("\\s+");
        if (parts.length == 3) {
            Command cmd = new Command(parts[0].toUpperCase(), parts[1], Long.parseLong(parts[2]));
            System.out.println("Successfully parsed Command Record -> Action: " + cmd.action() + 
                               ", Account: " + cmd.accountNo() + ", Amount: Rs. " + cmd.amount());
        } else {
            System.out.println("Invalid command format. Expected: ACTION ACCOUNT AMOUNT");
        }
    }
}
