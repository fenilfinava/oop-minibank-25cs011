// Practical 3 - Program 3: Fraction Simplification & Equality (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Fraction Simplification & Comparison ===");

        System.out.print("Enter Fraction 1 numerator and denominator: ");
        int n1 = sc.nextInt();
        int d1 = sc.nextInt();
        Fraction f1 = new Fraction(n1, d1);

        System.out.print("Enter Fraction 2 numerator and denominator: ");
        int n2 = sc.nextInt();
        int d2 = sc.nextInt();
        Fraction f2 = new Fraction(n2, d2);

        System.out.println("\nFraction 1: " + f1);
        System.out.println("Fraction 2: " + f2);
        System.out.println("Are both fractions equal? -> " + f1.equals(f2));
    }
}
