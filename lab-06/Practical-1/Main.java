// Practical: lab-06 - Practical-1 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        Switchable[] devices = { new Fan(), new Light() };
        for (Switchable s : devices) {
            s.toggle();
        }

        DeviceRule nightRule = new DeviceRule() {
            public boolean allow(Switchable device, int hour) {
                return hour >= 18 || hour <= 6;
            }
        };

        DeviceRule dayRule = (device, hour) -> hour >= 7 && hour <= 17;

        System.out.println("Night rule at 20h: " + nightRule.allow(devices[0], 20));
        System.out.println("Day rule at 20h: " + dayRule.allow(devices[0], 20));
    }
}
