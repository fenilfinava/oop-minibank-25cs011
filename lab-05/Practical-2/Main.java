// Practical: lab-05 - Practical-2 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTime("Rahul", "E101", 50000),
            new PartTime("Sneha", "E102", 40, 500),
            new Intern("Aman", "E103", 15000)
        };

        double totalPayroll = 0;
        for (Employee e : employees) {
            double sal = e.monthlySalary();
            System.out.print(e.getName() + " (" + e.getId() + "): Rs. " + sal);
            if (e instanceof Intern) {
                System.out.print(" [Note: Internship ends in 3 months]");
            }
            System.out.println();
            totalPayroll += sal;
        }

        System.out.println("Total Payroll: Rs. " + totalPayroll);
    }
}
