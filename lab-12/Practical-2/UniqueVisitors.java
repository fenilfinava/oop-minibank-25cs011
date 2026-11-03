// Practical 12 - Program 2: Unique IP Visitors (HashSet) (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class UniqueVisitors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Unique Visitor IP Filter (HashSet) ===");
        System.out.println("Enter IP addresses one by one (type 'done' to finish):");

        Set<String> uniqueIPs = new HashSet<>();
        int totalInputs = 0;

        while (true) {
            System.out.print("Enter IP: ");
            String ip = sc.next();
            if (ip.equalsIgnoreCase("done")) break;
            uniqueIPs.add(ip);
            totalInputs++;
        }

        System.out.println("\nTotal IPs entered: " + totalInputs);
        System.out.println("Unique IP count: " + uniqueIPs.size());
        System.out.println("Distinct IPs List: " + uniqueIPs);
    }
}
