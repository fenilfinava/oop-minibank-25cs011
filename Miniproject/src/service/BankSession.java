package service;

public class BankSession implements AutoCloseable {
    public BankSession() {
        System.out.println("Bank session initiated.");
    }

    public void close() {
        System.out.println("Bank session terminated safely.");
    }
}
