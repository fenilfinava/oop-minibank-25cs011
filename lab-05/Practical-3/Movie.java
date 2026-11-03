// Practical: lab-05 - Practical-3 (Movie.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Movie extends Media {
    public Movie(String title) {
        super(title);
    }

    public double computeLateFee(int days) {
        return days * 5.0;
    }
}
