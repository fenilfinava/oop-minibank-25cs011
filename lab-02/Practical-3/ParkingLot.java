// Practical: lab-02 - Practical-3 (ParkingLot.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class ParkingLot {
    private int twoWheelers;
    // private data field encapsulation mate
    private int fourWheelers;
    // private data field encapsulation mate
    private final int twoCap;
    // private data field encapsulation mate
    private final int fourCap;
    // private data field encapsulation mate
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
                return true;
            } else {
                System.out.println("Full");
                return false;
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                return true;
            } else {
                System.out.println("Full");
                return false;
            }
        }
        return false;
    }

    public void leave(String type) {
        if (type.equalsIgnoreCase("two") && twoWheelers > 0) {
            twoWheelers--;
        } else if (type.equalsIgnoreCase("four") && fourWheelers > 0) {
            fourWheelers--;
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 2);
        System.out.println("Park two: " + lot.park("two"));
        System.out.println("Park two: " + lot.park("two"));
        System.out.println("Park two: " + lot.park("two"));
        System.out.println("Park four: " + lot.park("four"));
        lot.leave("two");
        System.out.println("Park two after leave: " + lot.park("two"));
        System.out.println("Total revenue: " + revenue);
    }
}
