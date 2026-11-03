// Practical: lab-05 - Practical-1 (Circle.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Circle extends Shape {
    private double radius;
    // private data field encapsulation mate

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
