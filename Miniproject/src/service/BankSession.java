package service;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class BankSession implements AutoCloseable {
    public BankSession() {
        System.out.println("Bank session initiated.");
    }

    public void close() {
        System.out.println("Bank session terminated safely.");
    }
}
