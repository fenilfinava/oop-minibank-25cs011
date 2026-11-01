import java.nio.file.Files;
import java.nio.file.Path;
import model.Account;
import model.CurrentAccount;
import model.FixedDepositAccount;
import model.SavingsAccount;
import service.ReportGenerator;
import util.StatePersister;
import util.TransactionLog;

public class MiniBank {
    public static void main(String[] args) throws Exception {
        Account[] accounts = {
            new SavingsAccount("Alice", 7000, 1000),
            new CurrentAccount("Bob", 4000, 2000),
            new FixedDepositAccount("Charlie", 50000)
        };

        Path dataFile = Files.createTempFile("accounts_", ".dat");
        StatePersister.save(accounts, dataFile);

        Account[] loaded = StatePersister.load(dataFile);
        System.out.println("Reloaded accounts successfully: " + loaded.length + " accounts.");
        for (Account a : loaded) {
            System.out.println("  " + a);
        }
        Files.deleteIfExists(dataFile);

        Path logDir = Files.createTempDirectory("bank_logs_");
        Path logFile = logDir.resolve("daily.log");
        TransactionLog.append(logFile, "DEPOSIT AC0001 500");
        TransactionLog.append(logFile, "WITHDRAW AC0002 200");

        Path reportFile = logDir.resolve("report.txt");
        ReportGenerator.generateReport(logDir, reportFile);

        System.out.println(Files.readString(reportFile));
        Files.deleteIfExists(logFile);
        Files.deleteIfExists(reportFile);
        Files.deleteIfExists(logDir);
    }
}
