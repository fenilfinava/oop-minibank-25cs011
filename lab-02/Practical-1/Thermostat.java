// Practical 2 - Program 1: Smart Thermostat (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Thermostat {
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0; // badha objects vachhe share thay

    // 2-parameter constructor
    public Thermostat(String location, int startTemp) {
        this.location = location;
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            System.out.println("Invalid temp (" + startTemp + "). Setting to default 22 C.");
            this.temperature = 22;
        }
        activeCount++;
    }

    // constructor chaining - this() no use karyo
    public Thermostat(String location) {
        this(location, 22);
    }

    public void raise() {
        if (temperature < MAX) {
            temperature++;
            System.out.println(location + " -> Temp increased to: " + temperature + " C");
        } else {
            System.out.println(location + " -> Already at maximum (" + MAX + " C)");
        }
    }

    public void lower() {
        if (temperature > MIN) {
            temperature--;
            System.out.println(location + " -> Temp decreased to: " + temperature + " C");
        } else {
            System.out.println(location + " -> Already at minimum (" + MIN + " C)");
        }
    }

    public int getTemperature() { return temperature; }
    public String getLocation() { return location; }
    public static int getActiveCount() { return activeCount; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Smart Thermostat Controller ===");
        
        System.out.print("Enter thermostat location (e.g. Living Room): ");
        String loc = sc.nextLine();
        System.out.print("Enter initial temperature (16 to 30 C): ");
        int initialTemp = sc.nextInt();

        Thermostat t = new Thermostat(loc, initialTemp);
        System.out.println("Thermostat initialized at " + t.getLocation() + " with " + t.getTemperature() + " C.");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Raise Temp (+1)  2. Lower Temp (-1)  3. View Status  4. Exit");
            System.out.print("Enter choice (1-4): ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> t.raise();
                case 2 -> t.lower();
                case 3 -> System.out.println("Current Status: " + t.getLocation() + " is at " + t.getTemperature() + " C (Active Devices: " + Thermostat.getActiveCount() + ")");
                case 4 -> {
                    System.out.println("Exiting Thermostat Controller.");
                    running = false;
                }
                default -> System.out.println("Invalid option! Please enter 1 to 4.");
            }
        }
    }
}
