// Practical: lab-05 - Practical-2 (FullTime.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class FullTime extends Employee {
    private double fixedSalary;
    // private data field encapsulation mate

    public FullTime(String name, String id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    public double monthlySalary() {
        return fixedSalary;
    }
}
