// Practical 13 - Program 3: Generic Array-Backed Stack (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Generic Stack<T> Interactive Tester ===");
        GenericStack<String> stack = new GenericStack<>();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Push String  2. Pop String  3. Check Empty  4. Exit");
            System.out.print("Enter choice (1-4): ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter string to push: ");
                    String s = sc.next();
                    stack.push(s);
                    System.out.println("Pushed: " + s);
                }
                case 2 -> {
                    if (!stack.isEmpty()) {
                        System.out.println("Popped: " + stack.pop());
                    } else {
                        System.out.println("Stack is empty!");
                    }
                }
                case 3 -> System.out.println("Stack is empty? -> " + stack.isEmpty());
                case 4 -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
