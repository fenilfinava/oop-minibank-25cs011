// Practical 8 - Program 1: Custom Exception Calculator (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Safe Integer Division Calculator ===");

        System.out.print("Enter numerator: ");
        int num = sc.nextInt();
        System.out.print("Enter denominator (enter 0 to test exception): ");
        int den = sc.nextInt();

        try {
            int result = Calculator.divide(num, den);
            System.out.println("Calculation Result: " + num + " / " + den + " = " + result);
        } catch (DivideByZeroException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        } finally {
            System.out.println("Cleanup: Calculation transaction finished.");
        }
    }
}
