// Practical 5 - Program 2: Employee Hierarchy & Payroll (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Employee Payroll System ===");

        System.out.print("Enter FullTime Employee monthly salary: Rs. ");
        double ftSal = sc.nextDouble();
        Employee ft = new FullTime("Fenil", "E101", ftSal);

        System.out.print("Enter PartTime Employee hours worked & hourly rate: ");
        int ptHours = sc.nextInt();
        double ptRate = sc.nextDouble();
        Employee pt = new PartTime("Amit", "E102", ptHours, ptRate);

        System.out.print("Enter Intern monthly stipend: Rs. ");
        double stipend = sc.nextDouble();
        Employee in = new Intern("Pooja", "E103", stipend);

        Employee[] staff = { ft, pt, in };
        System.out.println("\n--- Monthly Compensation Breakdown ---");
        for (Employee e : staff) {
            System.out.printf("%-10s (%-8s | ID: %s) -> Total Pay: Rs. %,.2f%n", 
                              e.getName(), e.getClass().getSimpleName(), e.getId(), e.monthlySalary());
        }
    }
}
