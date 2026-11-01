public class Main {
    public static void main(String[] args) {
        String[] headers = { "emp_name", "emp_city" };
        String[] row = { "Rahul", "Surat" };

        EmployeeRecord record = CsvMapper.mapRow(EmployeeRecord.class, headers, row);
        System.out.println("Mapped object: " + record);
    }
}
