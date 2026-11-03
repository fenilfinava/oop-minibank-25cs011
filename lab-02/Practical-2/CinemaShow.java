// Practical 2 - Program 2: Cinema Show Booking (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public CinemaShow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n > 0 && n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    public void cancel(int n) {
        if (n > 0) {
            seatsAvailable += n;
            if (seatsAvailable > capacity) seatsAvailable = capacity;
            totalBooked -= n;
            if (totalBooked < 0) totalBooked = 0;
            System.out.println("Cancelled " + n + " seats successfully.");
        }
    }

    public int getSeatsAvailable() { return seatsAvailable; }
    public String getTitle() { return title; }
    public static int getTotalBooked() { return totalBooked; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Cinema Show Reservation System ===");
        
        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Hall Capacity (e.g. 50): ");
        int cap = sc.nextInt();

        CinemaShow show = new CinemaShow(title, cap);
        System.out.println("Show created: '" + show.getTitle() + "' with capacity " + cap);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Book Tickets  2. Cancel Tickets  3. Check Availability  4. Exit");
            System.out.print("Enter choice (1-4): ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter number of seats to book: ");
                    int count = sc.nextInt();
                    if (show.book(count)) {
                        System.out.println("Success! Booked " + count + " seats. Seats left: " + show.getSeatsAvailable());
                    } else {
                        System.out.println("Booking Failed! Only " + show.getSeatsAvailable() + " seats available.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter number of seats to cancel: ");
                    int count = sc.nextInt();
                    show.cancel(count);
                    System.out.println("Seats available now: " + show.getSeatsAvailable());
                }
                case 3 -> {
                    System.out.println("Movie: " + show.getTitle() + " | Available: " + show.getSeatsAvailable() + " | Total Booked: " + CinemaShow.getTotalBooked());
                }
                case 4 -> {
                    System.out.println("Exiting Cinema System. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
