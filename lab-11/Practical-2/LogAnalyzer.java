// Practical 11 - Program 2: Log File Character Stream Analyzer (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.io.*;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Server Log Character Stream Analyzer ===");

        File logFile = new File("test_server.log");
        try (PrintWriter pw = new PrintWriter(new FileWriter(logFile))) {
            pw.println("2026-11-03 10:00:01 INFO Server started successfully on port 8080");
            pw.println("2026-11-03 10:02:15 WARNING High memory usage: 82% threshold");
            pw.println("2026-11-03 10:05:30 ERROR Database connection timeout on node 2");
            pw.println("2026-11-03 10:06:00 INFO Connection pool restored");
            pw.println("2026-11-03 10:08:45 ERROR Failed to process transaction TXN991");
        }

        System.out.println("Sample server log created with 5 entries.");
        System.out.print("Enter keyword to count occurrences (e.g. ERROR / WARNING / INFO): ");
        String target = sc.next().toUpperCase();

        int totalLines = 0, count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                if (line.contains(target)) {
                    count++;
                    System.out.println("  Matched line " + totalLines + ": " + line);
                }
            }
        }

        System.out.println("\nSummary -> Total Lines Scanned: " + totalLines + " | Total '" + target + "' found: " + count);
        logFile.deleteOnExit();
    }
}
