public class AudioCD extends Media {
    public AudioCD(String title) {
        super(title);
    }

    public double computeLateFee(int days) {
        return days * 1.0;
    }
}
