// Practical: lab-08 - Practical-2 (OutOfStockException.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class OutOfStockException extends Exception {
    private int shortfall;
    // private data field encapsulation mate

    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}
