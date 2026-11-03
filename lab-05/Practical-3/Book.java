// Practical: lab-05 - Practical-3 (Book.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Book extends Media {
    public Book(String title) {
        super(title);
    }

    public double computeLateFee(int days) {
        return days * 2.0;
    }
}
