package exception;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class AccountNotFoundException extends BankException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
