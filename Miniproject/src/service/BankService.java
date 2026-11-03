package service;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import exception.AccountNotFoundException;
import exception.BankException;
import exception.InvalidAmountException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import model.Account;
import repository.Repository;
import util.StatePersister;
import util.StatementFormatter;
import util.TransactionLog;
import util.Validator;

public class BankService {
    private Repository<Account> repository = new Repository<>();
    private Path logFile = Path.of("logs/transactions.log");

    public void openAccount(Account account) {
        repository.save(account);
        try {
            TransactionLog.append(logFile, "OPEN " + account.getAccountNumber() + " " + account.getBalance());
        } catch (IOException e) {
        }
    }

    public Account getAccount(String accNo) throws AccountNotFoundException {
        Account acc = repository.findById(accNo);
        if (acc == null) {
            throw new AccountNotFoundException("Account not found: " + accNo);
        }
        return acc;
    }

    public void deposit(String accNo, long amount) throws BankException {
        Account acc = getAccount(accNo);
        acc.deposit(amount);
        try {
            TransactionLog.append(logFile, "DEPOSIT " + accNo + " " + amount);
        } catch (IOException e) {
        }
    }

    public void withdraw(String accNo, long amount) throws BankException {
        Account acc = getAccount(accNo);
        acc.withdraw(amount);
        try {
            TransactionLog.append(logFile, "WITHDRAW " + accNo + " " + amount);
        } catch (IOException e) {
        }
    }

    public void transfer(String fromAccNo, String toAccNo, long amount) throws BankException {
        Account from = getAccount(fromAccNo);
        Account to = getAccount(toAccNo);
        TransactionProcessor.transferSafe(from, to, amount);
        try {
            TransactionLog.append(logFile, "WITHDRAW " + fromAccNo + " " + amount);
            TransactionLog.append(logFile, "DEPOSIT " + toAccNo + " " + amount);
        } catch (IOException e) {
        }
    }

    public String statement(String accNo) throws AccountNotFoundException {
        Account acc = getAccount(accNo);
        return StatementFormatter.buildStatement(acc);
    }

    public ArrayList<Account> listAccounts() {
        ArrayList<Account> list = repository.findAll();
        list.sort(Comparator.comparingLong(Account::getBalance).reversed());
        return list;
    }

    public void saveAccounts(Path file) throws IOException {
        ArrayList<Account> list = repository.findAll();
        StatePersister.save(list.toArray(new Account[0]), file);
    }

    public void loadAccounts(Path file) throws IOException, ClassNotFoundException {
        Account[] loaded = StatePersister.load(file);
        for (Account a : loaded) {
            repository.save(a);
        }
    }

    public void generateReport(Path logsDir, Path reportFile) throws IOException {
        ReportGenerator.generateReport(logsDir, reportFile);
    }
}
