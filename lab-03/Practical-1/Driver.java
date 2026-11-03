// Practical 3 - Program 1: Distinct Points (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Distinct 2D Points Tester ===");
        System.out.print("How many points do you want to enter? (e.g. 5): ");
        int n = sc.nextInt();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Point " + (i + 1) + " (x and y separated by space): ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        System.out.println("\n--- Entered Points ---");
        for (Point p : points) {
            System.out.println(p.toString() + " | HashCode: " + p.hashCode());
        }

        // Count unique points using equals()
        ArrayList<Point> uniquePoints = new ArrayList<>();
        for (Point p : points) {
            if (!uniquePoints.contains(p)) {
                uniquePoints.add(p);
            }
        }

        System.out.println("\nTotal points entered: " + points.length);
        System.out.println("Distinct points count: " + uniquePoints.size());
        System.out.println("Unique points: " + uniquePoints);
    }
}
