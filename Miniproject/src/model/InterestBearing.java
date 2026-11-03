package model;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public interface InterestBearing {
    double interestRate();
    long getBalance();
    default double yearlyInterest() {
        return getBalance() * interestRate() / 100.0;
    }
}
