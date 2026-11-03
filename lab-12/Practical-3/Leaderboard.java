// Practical: lab-12 - Practical-3 (Leaderboard.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Fenil", 85);
        scores.put("Aarav", 92);
        scores.put("Priya", 92);
        scores.put("Rohan", 78);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(scores.entrySet());
        list.sort((e1, e2) -> {
            int cmp = e2.getValue().compareTo(e1.getValue());
            return cmp != 0 ? cmp : e1.getKey().compareTo(e2.getKey());
        });

        System.out.println("Leaderboard (Top 3):");
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " (" + entry.getValue() + " pts)");
        }
    }
}
