// Practical: lab-08 - Practical-1 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        String[] inputs = { "10,0", "abc,2", "20,4" };

        for (String input : inputs) {
            try {
                String[] parts = input.split(",");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int res = Calculator.divide(a, b);
                System.out.println("Result of " + a + " / " + b + " = " + res);
                break;
            } catch (DivideByZeroException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number input");
            } finally {
                System.out.println("Attempt logged");
            }
        }
    }
}
