public class Main {
    public static void main(String[] args) {
        Media[] items = {
            new Book("Clean Code"),
            new Movie("Interstellar"),
            new AudioCD("Beethoven Symphony No. 5")
        };

        int lateDays = 4;
        double totalFees = 0;

        for (Media m : items) {
            double fee = m.computeLateFee(lateDays);
            System.out.println(m.getTitle() + " late fee: Rs. " + fee);
            totalFees += fee;
        }

        System.out.println("Total late fees for returned batch: Rs. " + totalFees);
    }
}
