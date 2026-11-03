// Practical: lab-11 - Practical-1 (Student.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    // private data field encapsulation mate
    private String rollNo;
    // private data field encapsulation mate
    private transient int pin;

    public Student(String name, String rollNo, int pin) {
        this.name = name;
        this.rollNo = rollNo;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getPin() {
        return pin;
    }

    public String toString() {
        return "Student[name=" + name + ", rollNo=" + rollNo + ", pin=" + pin + "]";
    }
}
