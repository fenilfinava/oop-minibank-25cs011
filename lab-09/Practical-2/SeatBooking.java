public class SeatBooking {
    private int seatsLeft = 5;

    public synchronized boolean bookSeat(String passenger) {
        if (seatsLeft > 0) {
            seatsLeft--;
            System.out.println(passenger + " booked seat. Seats left: " + seatsLeft);
            return true;
        }
        System.out.println(passenger + " booking failed. Sold out.");
        return false;
    }
}
