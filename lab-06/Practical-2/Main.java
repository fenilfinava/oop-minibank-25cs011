// Practical 6 - Program 2: Notifier System & Marker Interface (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Alert & Notification Dispatcher ===");

        System.out.print("Enter message to broadcast: ");
        String msg = sc.nextLine();
        System.out.print("Is this an URGENT notification? (yes/no): ");
        String urgent = sc.next();

        Notifier notifier;
        if (urgent.equalsIgnoreCase("yes")) {
            notifier = new UrgentSMSNotifier();
        } else {
            notifier = new EmailNotifier();
        }

        System.out.println("\n--- Notification Dispatch Status ---");
        boolean isUrgent = notifier instanceof Urgent;
        System.out.println("Marker Interface [Urgent] Detected: " + isUrgent);
        notifier.send(msg);
    }
}

class UrgentSMSNotifier implements Notifier, Urgent {
    public void send(String msg) {
        System.out.println("[PRIORITY SMS] Sent high-priority alert: '" + msg + "'");
    }
}

class EmailNotifier implements Notifier {
    public void send(String msg) {
        System.out.println("[STANDARD EMAIL] Sent regular notification: '" + msg + "'");
    }
}
