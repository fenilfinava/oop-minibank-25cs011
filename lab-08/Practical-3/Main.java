// Practical: lab-08 - Practical-3 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        try (TestResource res = new TestResource("MyResource")) {
            res.doWork(true);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
