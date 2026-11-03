// Practical: lab-05 - Practical-2 (Intern.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Intern extends Employee {
    private double stipend;
    // private data field encapsulation mate

    public Intern(String name, String id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    public double monthlySalary() {
        return stipend;
    }
}
