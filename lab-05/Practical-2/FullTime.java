public class FullTime extends Employee {
    private double fixedSalary;

    public FullTime(String name, String id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }

    public double monthlySalary() {
        return fixedSalary;
    }
}
