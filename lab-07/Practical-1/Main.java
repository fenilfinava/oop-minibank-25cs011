// Practical 7 - Program 1: Form Validation via Custom Annotations & Reflection (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== User Registration Form Validator ===");

        System.out.print("Enter Username (can try leaving blank): ");
        String username = sc.nextLine();
        System.out.print("Enter Password (max length 8): ");
        String password = sc.nextLine();

        SignupForm form = new SignupForm(username, password);
        List<String> errors = FormValidator.validate(form);

        System.out.println("\n--- Reflection Validation Results ---");
        if (errors.isEmpty()) {
            System.out.println("Validation SUCCESS! Form is completely valid.");
        } else {
            System.out.println("Validation FAILED with " + errors.size() + " error(s):");
            for (String err : errors) {
                System.out.println("  • " + err);
            }
        }
    }
}
