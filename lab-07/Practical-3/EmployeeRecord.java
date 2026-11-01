public class EmployeeRecord {
    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_city")
    private String city;

    public String toString() {
        return "EmployeeRecord [name=" + name + ", city=" + city + "]";
    }
}
