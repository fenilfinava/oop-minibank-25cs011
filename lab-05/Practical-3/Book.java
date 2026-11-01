public class Book extends Media {
    public Book(String title) {
        super(title);
    }

    public double computeLateFee(int days) {
        return days * 2.0;
    }
}
