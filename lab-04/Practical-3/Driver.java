// Practical 4 - Program 3: Template Replacement Engine (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Regex Template Engine ===");
        String template = "Dear {name}, your order {id} is scheduled for delivery on {date}.";
        System.out.println("Base Template: " + template);

        System.out.print("Enter customer name (for {name}): ");
        String name = sc.nextLine();
        System.out.print("Enter order ID (for {id}): ");
        String id = sc.nextLine();
        System.out.print("Enter delivery date (for {date}): ");
        String date = sc.nextLine();

        String[] keys = {"name", "id", "date"};
        String[] vals = {name, id, date};

        Pattern p = Pattern.compile("\\{(\\w+)\\}");
        Matcher m = p.matcher(template);
        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            String placeholder = m.group(1);
            String replacement = "[?]";
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].equalsIgnoreCase(placeholder)) {
                    replacement = vals[i];
                    break;
                }
            }
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);

        System.out.println("\nGenerated Final Message:\n" + sb.toString());
    }
}
