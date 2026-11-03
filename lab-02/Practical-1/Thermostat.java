// Practical: lab-02 - Practical-1 (Thermostat.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Thermostat {
    private String location;
    // private data field encapsulation mate
    private int temperature;
    // private data field encapsulation mate
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    public Thermostat(String location, int startTemp) {
        this.location = location;
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }
        activeCount++;
    }

    public Thermostat(String location) {
        this(location, 22);
    }

    public void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)");
        }
    }

    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }

    public static int getActiveCount() {
        return activeCount;
    }

    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("Living Room", 25);
        Thermostat t2 = new Thermostat("Bedroom");

        System.out.println("Thermostat 1 (" + t1.getLocation() + "):");
        for (int i = 0; i < 10; i++) {
            t1.raise();
            System.out.println("Temp: " + t1.getTemperature());
        }
        for (int i = 0; i < 20; i++) {
            t1.lower();
            System.out.println("Temp: " + t1.getTemperature());
        }

        System.out.println("Active thermostats: " + Thermostat.getActiveCount());
    }
}
