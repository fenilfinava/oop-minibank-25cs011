package model;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

public interface Transactable {
    void deposit(long amount) throws InvalidAmountException;
    boolean withdraw(long amount) throws InsufficientFundsException, InvalidAmountException;
}
