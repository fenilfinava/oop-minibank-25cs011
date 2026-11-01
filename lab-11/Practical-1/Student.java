import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String rollNo;
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
