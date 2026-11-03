// Practical: lab-05 - Practical-2 (Employee.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public abstract class Employee {
    private String name;
    // private data field encapsulation mate
    private String id;
    // private data field encapsulation mate

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public abstract double monthlySalary();
}
