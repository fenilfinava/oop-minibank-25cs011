// Practical: lab-08 - Practical-2 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) {
        Warehouse wh = new Warehouse();
        wh.addStock("Keyboard", 5);

        int[] requests = { 2, -1, 10 };
        for (int req : requests) {
            try {
                wh.issue("Keyboard", req);
                System.out.println("Issued " + req + " keyboards successfully");
            } catch (OutOfStockException e) {
                System.out.println("Failed: " + e.getMessage() + ", shortfall: " + e.getShortfall());
            } catch (InvalidQuantityException e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }
    }
}
