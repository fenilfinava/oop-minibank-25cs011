// Practical: lab-09 - Practical-2 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SeatBooking sb = new SeatBooking();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            final String name = "User-" + (i + 1);
            threads[i] = new Thread(() -> sb.bookSeat(name));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}
