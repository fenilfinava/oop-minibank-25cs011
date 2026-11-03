// Practical: lab-06 - Practical-2 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    static class UrgentEmailNotifier implements Notifier, Urgent {
        public void send(String msg) {
            System.out.println("Email: " + msg);
        }
    }

    public static void main(String[] args) {
        Notifier smsNotifier = msg -> System.out.println("SMS: " + msg);
        Notifier emailNotifier = new UrgentEmailNotifier();

        Notifier[] senders = { smsNotifier, emailNotifier };
        String broadcast = "Server maintenance at 11 PM";

        for (Notifier n : senders) {
            n.send(broadcast);
            if (n instanceof Urgent) {
                n.send(broadcast);
            }
        }
    }
}
