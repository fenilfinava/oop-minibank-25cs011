// Practical: lab-05 - Practical-1 (Triangle.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Triangle extends Shape {
    private double base;
    // private data field encapsulation mate
    private double height;
    // private data field encapsulation mate

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}
