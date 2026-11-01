import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    public static void main(String[] args) {
        String template = "Dear {name}, order {id} ships {date}.";
        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        Pattern p = Pattern.compile("\\{(\\w+)\\}");
        Matcher m = p.matcher(template);
        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            String placeholder = m.group(1);
            String replacement = "[?]";
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(placeholder)) {
                    replacement = values[i];
                    break;
                }
            }
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);

        System.out.println(sb.toString());
    }
}
