package exception;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class InsufficientFundsException extends BankException {
    private long shortfall;

    public InsufficientFundsException(String message, long shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public long getShortfall() {
        return shortfall;
    }
}
