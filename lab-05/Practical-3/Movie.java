public class Movie extends Media {
    public Movie(String title) {
        super(title);
    }

    public double computeLateFee(int days) {
        return days * 5.0;
    }
}
