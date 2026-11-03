// Practical: lab-07 - Practical-3 (EmployeeRecord.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class EmployeeRecord {
    @Column(name = "emp_name")
    private String name;
    // private data field encapsulation mate

    @Column(name = "emp_city")
    private String city;
    // private data field encapsulation mate

    public String toString() {
        return "EmployeeRecord [name=" + name + ", city=" + city + "]";
    }
}
