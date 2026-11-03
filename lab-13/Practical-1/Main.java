// Practical 13 - Program 1: Generic Box<T> and Pair<A, B> (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Generic Containers (Type-Safety) ===");

        System.out.print("Enter a message to store in Box<String>: ");
        String msg = sc.nextLine();
        Box<String> box = new Box<>();
        box.set(msg);
        System.out.println("Box contents: '" + box.get() + "' (Type: String)");

        System.out.print("\nEnter key (String) and value (Integer) for Pair<String, Integer>: ");
        String key = sc.next();
        int val = sc.nextInt();
        Pair<String, Integer> pair = new Pair<>(key, val);
        System.out.println("Pair stored -> Key: " + pair.getFirst() + ", Value: " + pair.getSecond());
    }
}
