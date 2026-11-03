// Practical 6 - Program 1: Switchable Smart Devices (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Switchable light = new Light();
        Switchable fan = new Fan();

        System.out.println("=== Smart Home Device Controller ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Light ON  2. Light OFF  3. Fan ON  4. Fan OFF  5. Exit");
            System.out.print("Enter choice (1-5): ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> light.on();
                case 2 -> light.off();
                case 3 -> fan.on();
                case 4 -> fan.off();
                case 5 -> {
                    System.out.println("Switching off all devices and exiting.");
                    light.off();
                    fan.off();
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
