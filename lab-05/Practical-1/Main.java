// Practical 5 - Program 1: Shapes Hierarchy & Polymorphism (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Geometric Shapes Area Calculator ===");

        System.out.print("Enter Circle radius (e.g. 5.0): ");
        double r = sc.nextDouble();
        Shape circle = new Circle(r);

        System.out.print("Enter Rectangle width and height (e.g. 4.0 6.0): ");
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        Shape rectangle = new Rectangle(w, h);

        System.out.print("Enter Triangle base and height (e.g. 3.0 4.0): ");
        double b = sc.nextDouble();
        double th = sc.nextDouble();
        Shape triangle = new Triangle(b, th);

        Shape[] shapes = { circle, rectangle, triangle };
        System.out.println("\n--- Polymorphic Area Calculation Results ---");
        double totalArea = 0;
        for (Shape s : shapes) {
            System.out.printf("%-12s -> Computed Area: %8.2f%n", s.getClass().getSimpleName(), s.area());
            totalArea += s.area();
        }
        System.out.printf("Total Area of all shapes: %.2f%n", totalArea);
    }
}
