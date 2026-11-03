// Practical 7 - Program 3: CSV Column Mapper via Reflection (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== CSV to Object Reflection Mapper ===");
        String[] headers = { "id", "name", "dept" };

        System.out.print("Enter Employee ID (e.g. 101): ");
        String id = sc.next();
        System.out.print("Enter Employee Name: ");
        String name = sc.next();
        System.out.print("Enter Department: ");
        String dept = sc.next();

        String[] data = { id, name, dept };
        EmployeeRecord emp = CsvMapper.mapRow(EmployeeRecord.class, headers, data);

        System.out.println("\nSuccessfully mapped CSV to Java Object using Reflection:");
        System.out.println("EmployeeRecord -> " + emp);
    }
}
