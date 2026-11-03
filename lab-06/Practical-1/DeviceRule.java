// Practical: lab-06 - Practical-1 (DeviceRule.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
@FunctionalInterface
public interface DeviceRule {
    boolean allow(Switchable device, int hour);
}
