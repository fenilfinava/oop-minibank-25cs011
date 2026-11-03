// Practical: lab-07 - Practical-3 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        String[] headers = { "emp_name", "emp_city" };
        String[] row = { "Rahul", "Surat" };

        EmployeeRecord record = CsvMapper.mapRow(EmployeeRecord.class, headers, row);
        System.out.println("Mapped object: " + record);
    }
}
