// Practical: lab-01 - Practical-2 (TollBooth.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.Scanner;

public class TollBooth {
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {
            System.out.print("Enter vehicle number (or done): ");
            String num = sc.next();
            if (num.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().toLowerCase();
            Vehicle v = new Vehicle(num, type);

            int toll = switch (v.type()) {
                case "bike" -> {
                    bikeCount++;
                    yield 20;
                }
                case "car" -> {
                    carCount++;
                    yield 50;
                }
                case "truck" -> {
                    truckCount++;
                    yield 150;
                }
                default -> 0;
            };
            totalToll += toll;
        }

        System.out.println("Total toll: " + totalToll);
        String most = "car";
        int max = carCount;
        if (bikeCount > max) {
            most = "bike";
            max = bikeCount;
        }
        if (truckCount > max) {
            most = "truck";
        }
        System.out.println("Most frequent: " + most);
    }
}
