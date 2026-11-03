// Practical: lab-08 - Practical-2 (Warehouse.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();

    public void addStock(String item, int qty) {
        stock.put(item, stock.getOrDefault(item, 0) + qty);
    }

    public void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity must be positive: " + qty);
        }
        int available = stock.getOrDefault(item, 0);
        if (available < qty) {
            throw new OutOfStockException("Short of stock for " + item, qty - available);
        }
        stock.put(item, available - qty);
    }
}
