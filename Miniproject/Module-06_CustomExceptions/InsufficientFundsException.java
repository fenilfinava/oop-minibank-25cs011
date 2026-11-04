// MiniProject - Module 6: Custom Banking Exception Hierarchy
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)

class BankException extends Exception {
    public BankException(String message) {
        super(message);
    }
}

class InvalidAmountException extends BankException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

public class InsufficientFundsException extends BankException {
    private String accountNumber;
    private long requestedAmount;
    private long availableBalance;
    private long shortfall;

    public InsufficientFundsException(String accountNumber, long requestedAmount, long availableBalance) {
        super("Account " + accountNumber + " has insufficient funds for requested withdrawal of Rs. " + 
              requestedAmount + " (Available: Rs. " + availableBalance + ", Shortfall: Rs. " + (requestedAmount - availableBalance) + ")");
        this.accountNumber = accountNumber;
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
        this.shortfall = requestedAmount - availableBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public long getRequestedAmount() { return requestedAmount; }
    public long getAvailableBalance() { return availableBalance; }
    public long getShortfall() { return shortfall; }

    public static void main(String[] args) {
        Main.main(args);
    }
}
