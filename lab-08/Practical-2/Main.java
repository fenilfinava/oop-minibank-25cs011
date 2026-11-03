// Practical 8 - Program 2: Warehouse Exceptions (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Warehouse Inventory Dispatch System ===");

        Warehouse wh = new Warehouse();
        System.out.print("Enter initial stock for item 'Laptop' (e.g. 20): ");
        int stock = sc.nextInt();
        wh.addStock("Laptop", stock);

        System.out.print("Enter quantity to issue (try negative or greater than stock): ");
        int qty = sc.nextInt();

        try {
            wh.issue("Laptop", qty);
            System.out.println("Issue successful! " + qty + " laptops dispatched.");
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage() + " (InvalidQuantityException)");
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage() + " (OutOfStockException - Shortfall: " + e.getShortfall() + ")");
        }
    }
}
