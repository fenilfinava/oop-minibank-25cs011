// MiniProject - Module 5: Interactive Custom Annotation Driver
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("  Module 5: Custom Annotations & Reflection Validator");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");

        System.out.println("\n[Testing AnnotationValidator with User Inputs]");
        System.out.print("Enter Account Number (e.g. AC1001): ");
        String accNo = sc.nextLine();

        System.out.print("Enter Owner Name (Max 15 chars, try longer to trigger rule): ");
        String name = sc.nextLine();

        System.out.print("Enter Opening Balance (Try negative or 0 to trigger @Positive): ");
        long bal = sc.nextLong();

        CustomerAccount acc = new CustomerAccount(accNo, name, bal);
        System.out.println("\n--- Performing Reflection-Based Validation ---");
        List<String> errors = AnnotationValidator.validate(acc);

        if (errors.isEmpty()) {
            System.out.println("STATUS: [PASSED] Entity is 100% compliant with all custom annotations!");
            System.out.println("Validated Account: " + acc.getAccountNumber() + " | " + acc.getOwnerName() + " | Rs. " + acc.getBalance());
        } else {
            System.out.println("STATUS: [FAILED] Validation violations detected (" + errors.size() + "):");
            for (String err : errors) {
                System.out.println("  -> " + err);
            }
        }
    }
}
