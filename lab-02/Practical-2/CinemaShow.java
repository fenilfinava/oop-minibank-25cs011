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
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    public void cancel(int n) {
        seatsAvailable = Math.min(capacity, seatsAvailable + n);
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public String getTitle() {
        return title;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Inception", 50);
        System.out.println("Booking 20 seats: " + show.book(20) + ", remaining: " + show.getSeatsAvailable());
        System.out.println("Booking 40 seats: " + show.book(40) + ", remaining: " + show.getSeatsAvailable());
        show.cancel(10);
        System.out.println("Cancelled 10 seats, remaining: " + show.getSeatsAvailable());
        System.out.println("Total booked across shows: " + CinemaShow.getTotalBooked());
    }
}
