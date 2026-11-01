public class PartTime extends Employee {
    private int hours;
    private double hourlyRate;

    public PartTime(String name, String id, int hours, double hourlyRate) {
        super(name, id);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    public double monthlySalary() {
        return hours * hourlyRate;
    }
}
