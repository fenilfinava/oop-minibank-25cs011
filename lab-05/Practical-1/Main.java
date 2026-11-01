public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8)
        };

        double totalArea = 0;
        double maxArea = 0;

        for (Shape s : shapes) {
            double a = s.area();
            System.out.println("Area: " + a);
            totalArea += a;
            if (a > maxArea) {
                maxArea = a;
            }
        }

        System.out.println("Total Area: " + totalArea);
        System.out.println("Largest Area: " + maxArea);
    }
}
