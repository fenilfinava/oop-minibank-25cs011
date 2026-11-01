import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = List.of("alice", "bob", "alice", "charlie", "bob", "david", "eva");

        Set<String> uniqueSet = new HashSet<>(logins);
        System.out.println("Unique visitors count: " + uniqueSet.size());

        Set<String> orderedSet = new LinkedHashSet<>(logins);
        System.out.println("First three distinct visitors:");
        int count = 0;
        for (String user : orderedSet) {
            if (count < 3) {
                System.out.println(" - " + user);
                count++;
            }
        }
    }
}
