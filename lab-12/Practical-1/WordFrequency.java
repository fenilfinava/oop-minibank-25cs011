// Practical: lab-12 - Practical-1 (WordFrequency.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java python java c++ java python rust c++ java";
        String[] words = text.toLowerCase().split("\\W+");

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
