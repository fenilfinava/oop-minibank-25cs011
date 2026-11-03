// Practical: lab-05 - Practical-2 (PartTime.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class PartTime extends Employee {
    private int hours;
    // private data field encapsulation mate
    private double hourlyRate;
    // private data field encapsulation mate

    public PartTime(String name, String id, int hours, double hourlyRate) {
        super(name, id);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    public double monthlySalary() {
        return hours * hourlyRate;
    }
}
