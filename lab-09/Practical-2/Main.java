// Practical 9 - Program 2: Concurrent Seat Booking (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Concurrent Seat Reservation Simulator ===");
        System.out.println("Default available seats: 5");

        System.out.print("Enter number of concurrent booking users (e.g. 7): ");
        int users = sc.nextInt();

        SeatBooking system = new SeatBooking();
        Thread[] threads = new Thread[users];

        for (int i = 0; i < users; i++) {
            final String user = "User-" + (i + 1);
            threads[i] = new Thread(() -> system.bookSeat(user));
            threads[i].start();
        }

        for (Thread t : threads) t.join();
        System.out.println("All reservation requests processed.");
    }
}
