// Practical 14 - Program 1: Layered Catalog & Simple Test Suite (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Layered Catalog Application ===");

        ItemService service = new ItemService();

        System.out.print("How many items do you want to add to catalog? ");
        int count = sc.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter Item " + i + " (ID Name Price): ");
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            try {
                service.addItem(new Item(id, name, price));
                System.out.println("Item added successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
            }
        }

        System.out.println("\n--- Current Catalog Items (" + service.count() + ") ---");
        for (Item it : service.getItems()) {
            System.out.println("  " + it);
        }

        System.out.println("\n--- Running Automated Unit Tests ---");
        SimpleTestRunner.main(new String[0]);
    }
}
