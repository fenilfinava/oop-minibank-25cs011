package model;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
@FunctionalInterface
public interface WithdrawRule {
    boolean allow(Account account, long amount);
}
