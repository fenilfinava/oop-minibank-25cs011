// Practical 4 - Program 1: Password Strength Evaluator (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Password Security & Strength Checker ===");

        while (true) {
            System.out.print("\nEnter password to evaluate (or 'exit' to quit): ");
            String pw = sc.nextLine();
            if (pw.equalsIgnoreCase("exit")) break;

            String strength = PasswordChecker.strength(pw);
            System.out.println("Result: Password '" + pw + "' -> Strength: " + strength);
        }
    }
}
