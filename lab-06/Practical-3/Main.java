// Practical 6 - Program 3: Functional Interface & Lambdas (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Discount Engine (Functional Interface & Lambdas) ===");

        System.out.print("Enter total shopping bill amount: Rs. ");
        double bill = sc.nextDouble();

        System.out.println("\nChoose discount offer:");
        System.out.println("1. Festive Offer (20% off)");
        System.out.println("2. Member Loyalty (10% off)");
        System.out.println("3. Custom Promotional Coupon");
        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();

        DiscountRule rule = switch (choice) {
            case 1 -> amt -> amt * 0.80; // 20% discount lambda
            case 2 -> amt -> amt * 0.90; // 10% discount lambda
            case 3 -> {
                System.out.print("Enter custom discount percentage (e.g. 15): ");
                double pct = sc.nextDouble();
                yield amt -> amt * (1.0 - (pct / 100.0));
            }
            default -> amt -> amt;
        };

        double finalBill = rule.apply(bill);
        System.out.printf("Original Bill: Rs. %.2f | Final Bill after discount: Rs. %.2f%n", bill, finalBill);
    }
}
