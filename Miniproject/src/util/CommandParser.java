package util;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import model.Command;
import model.TransactionType;

public class CommandParser {
    public static Command parse(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length < 3) {
            return null;
        }
        TransactionType type = TransactionType.valueOf(parts[0].toUpperCase());
        String acc = parts[1];
        long amt = Long.parseLong(parts[2]);
        return new Command(type, acc, amt);
    }
}
