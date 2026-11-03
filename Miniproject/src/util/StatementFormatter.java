package util;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import model.Account;

public class StatementFormatter {
    public static String buildStatement(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n");
        sb.append("ACCOUNT STATEMENT\n");
        sb.append("Account Number: ").append(account.getAccountNumber()).append("\n");
        sb.append("Owner Name    : ").append(account.getOwnerName()).append("\n");
        sb.append("Balance       : Rs. ").append(account.getBalance()).append("\n");
        sb.append("Status        : ").append(account.isActive() ? "Active" : "Inactive").append("\n");
        sb.append("------------------------------\n");
        return sb.toString();
    }
}
