// Practical 4 - Program 2: Chat Log Filter & Search (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello team, good morning",
            "10:06 bob What is the update on assignment?",
            "10:07 david Please review the pull request",
            "10:08 charlie hello all, let us meet at 4 PM"
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Chat Log Keyword Search System ===");
        System.out.println("Available logs count: " + logs.length);
        System.out.print("Enter keyword to search in logs (e.g. hello / update): ");
        String keyword = sc.nextLine().toLowerCase();

        int matches = 0;
        StringBuilder report = new StringBuilder();

        for (String line : logs) {
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) continue;
            String time = parts[0], user = parts[1], msg = parts[2];

            if (msg.toLowerCase().contains(keyword)) {
                matches++;
                report.append("  [").append(time).append("] ").append(user).append(": ").append(msg).append("\n");
            }
        }

        System.out.println("\nSearch completed. Found " + matches + " match(es):");
        System.out.print(report.toString());
    }
}
