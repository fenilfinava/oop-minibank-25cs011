// Practical 5 - Program 3: Digital Media Catalog (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Media Library Late Fee Calculator ===");

        System.out.print("Enter Book Title: ");
        String bTitle = sc.next();
        Media book = new Book(bTitle);

        System.out.print("Enter Movie Title: ");
        String mTitle = sc.next();
        Media movie = new Movie(mTitle);

        System.out.print("Enter AudioCD Title: ");
        String cTitle = sc.next();
        Media cd = new AudioCD(cTitle);

        System.out.print("\nEnter overdue days to calculate late fee: ");
        int days = sc.nextInt();

        Media[] items = { book, movie, cd };
        System.out.println("\n--- Library Overdue Fee Calculation ---");
        for (Media m : items) {
            System.out.printf("%-12s: '%s' -> Late Fee (%d days): Rs. %.2f%n", 
                              m.getClass().getSimpleName(), m.getTitle(), days, m.computeLateFee(days));
        }
    }
}
