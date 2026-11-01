import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] prices = { 100.0, 250.0, 500.0, 1200.0 };
        Scanner sc = new Scanner(System.in);

        DiscountRule rule;
        int choice = 1;
        if (choice == 1) {
            rule = p -> p * 0.90;
        } else {
            rule = p -> Math.max(0, p - 50);
        }

        System.out.println("Prices after discount:");
        for (double p : prices) {
            System.out.println("Original: " + p + " -> Discounted: " + rule.apply(p));
        }
    }
}
