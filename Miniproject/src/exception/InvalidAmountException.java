package exception;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class InvalidAmountException extends BankException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
