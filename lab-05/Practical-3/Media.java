// Practical: lab-05 - Practical-3 (Media.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public abstract class Media {
    private String title;
    // private data field encapsulation mate

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double computeLateFee(int days);
}
