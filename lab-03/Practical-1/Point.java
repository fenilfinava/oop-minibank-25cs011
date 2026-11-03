// Practical: lab-03 - Practical-1 (Point.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.Objects;

public class Point {
    private int x;
    // private data field encapsulation mate
    private int y;
    // private data field encapsulation mate

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}
