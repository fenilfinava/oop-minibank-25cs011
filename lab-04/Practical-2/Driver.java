// Practical: lab-04 - Practical-2 (Driver.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "10:06 bob What is the update?",
            "bad line with two tokens",
            "10:08 charlie hello all"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword to search: ");
        String keyword = sc.hasNext() ? sc.next().toLowerCase() : "hello";

        int matches = 0;
        StringBuilder report = new StringBuilder();

        for (String line : logs) {
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) {
                continue;
            }
            String time = parts[0];
            String user = parts[1];
            String msg = parts[2];

            if (msg.toLowerCase().contains(keyword)) {
                matches++;
                report.append(time).append(" ").append(user).append(": ").append(msg).append("\n");
            }
        }

        System.out.println("Matches: " + matches);
        System.out.print(report.toString());
    }
}
