// Practical 2 - Program 3: Parking Lot Management (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class ParkingLot {
    private int twoWheelers = 0;
    private int fourWheelers = 0;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public boolean park(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("2-Wheeler parked. Fee: Rs. 20. Slots: " + twoWheelers + "/" + twoCap);
                return true;
            } else {
                System.out.println("Two-wheeler parking Full!");
                return false;
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("4-Wheeler parked. Fee: Rs. 40. Slots: " + fourWheelers + "/" + fourCap);
                return true;
            } else {
                System.out.println("Four-wheeler parking Full!");
                return false;
            }
        }
        System.out.println("Invalid vehicle type (Enter 'two' or 'four').");
        return false;
    }

    public void leave(String type) {
        if (type.equalsIgnoreCase("two") && twoWheelers > 0) {
            twoWheelers--;
            System.out.println("2-Wheeler left. Slots available: " + (twoCap - twoWheelers));
        } else if (type.equalsIgnoreCase("four") && fourWheelers > 0) {
            fourWheelers--;
            System.out.println("4-Wheeler left. Slots available: " + (fourCap - fourWheelers));
        } else {
            System.out.println("No " + type + "-wheeler currently parked to leave.");
        }
    }

    public void displayStatus() {
        System.out.println("Occupancy -> 2-Wheelers: " + twoWheelers + "/" + twoCap + 
                           " | 4-Wheelers: " + fourWheelers + "/" + fourCap + 
                           " | Total Revenue: Rs. " + revenue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Parking Lot Entry & Toll System ===");
        System.out.print("Enter 2-wheeler slot capacity (e.g. 2): ");
        int twoC = sc.nextInt();
        System.out.print("Enter 4-wheeler slot capacity (e.g. 2): ");
        int fourC = sc.nextInt();

        ParkingLot lot = new ParkingLot(twoC, fourC);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Park Vehicle  2. Vehicle Departure  3. View Status & Revenue  4. Exit");
            System.out.print("Enter choice (1-4): ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter vehicle type (two / four): ");
                    String t = sc.next();
                    lot.park(t);
                }
                case 2 -> {
                    System.out.print("Enter vehicle type leaving (two / four): ");
                    String t = sc.next();
                    lot.leave(t);
                }
                case 3 -> lot.displayStatus();
                case 4 -> {
                    System.out.println("Closing Parking System. Final Revenue: Rs. " + revenue);
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
