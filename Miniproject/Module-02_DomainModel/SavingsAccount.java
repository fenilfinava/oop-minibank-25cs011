// MiniProject - Module 2: Subclasses (Savings, Current, FixedDeposit)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011

class SavingsAccount extends Account {
    private long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public synchronized boolean withdraw(long amount) {
        if (amount <= 0) {
            System.out.println("Error: Amount must be positive.");
            return false;
        }
        if (balance - amount < minBalance) {
            System.out.println("Withdrawal Denied: Balance cannot fall below minimum balance Rs. " + minBalance);
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawal of Rs. " + amount + " successful. Remaining Balance: Rs. " + balance);
        return true;
    }
}

class CurrentAccount extends Account {
    private long overdraftLimit;

    public CurrentAccount(String name, long balance, long overdraftLimit) {
        super(name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public synchronized boolean withdraw(long amount) {
        if (amount <= 0) {
            System.out.println("Error: Amount must be positive.");
            return false;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal Denied: Overdraft limit exceeded (Max overdraft: Rs. " + overdraftLimit + ")");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawal of Rs. " + amount + " successful. Remaining Balance: Rs. " + balance);
        return true;
    }
}

class FixedDepositAccount extends Account {
    private int termMonths;
    private double interestRate;

    public FixedDepositAccount(String name, long balance, int termMonths, double interestRate) {
        super(name, balance);
        this.termMonths = termMonths;
        this.interestRate = interestRate;
    }

    @Override
    public synchronized boolean withdraw(long amount) {
        System.out.println("Premature withdrawal penalty applied for Fixed Deposit (Term: " + termMonths + " months).");
        if (amount > balance) {
            System.out.println("Withdrawal Denied: Insufficient fixed deposit balance.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawal of Rs. " + amount + " processed. Remaining: Rs. " + balance);
        return true;
    }
}
