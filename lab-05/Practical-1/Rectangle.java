// Practical: lab-05 - Practical-1 (Rectangle.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Rectangle extends Shape {
    private double width;
    // private data field encapsulation mate
    private double height;
    // private data field encapsulation mate

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
