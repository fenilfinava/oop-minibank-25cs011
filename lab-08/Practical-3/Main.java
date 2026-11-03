// Practical 8 - Program 3: AutoCloseable & Try-with-Resources (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Resource Leak Prevention (AutoCloseable) ===");

        System.out.print("Enter resource name (e.g. DatabaseConnection): ");
        String name = sc.next();
        System.out.print("Do you want to simulate failure during work? (yes/no): ");
        boolean fail = sc.next().equalsIgnoreCase("yes");

        System.out.println("\nEntering try-with-resources block...");
        try (TestResource res = new TestResource(name)) {
            res.doWork(fail);
            System.out.println("Resource work completed successfully.");
        } catch (Exception e) {
            System.out.println("Caught Exception during work: " + e.getMessage());
        }
        System.out.println("Exited try-with-resources. Confirming resource was closed automatically!");
    }
}
