// Practical: lab-05 - Practical-3 (AudioCD.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class AudioCD extends Media {
    public AudioCD(String title) {
        super(title);
    }

    public double computeLateFee(int days) {
        return days * 1.0;
    }
}
