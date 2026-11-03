// Practical: lab-03 - Practical-3 (Driver.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Driver {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);

        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f1 equals f2: " + f1.equals(f2));
        System.out.println("f2 equals f3: " + f2.equals(f3));
    }
}
