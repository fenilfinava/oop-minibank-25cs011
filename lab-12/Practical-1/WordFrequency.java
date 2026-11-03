// Practical 12 - Program 1: Word Frequency Counter (HashMap) (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Word Frequency Counter (HashMap) ===");
        System.out.println("Enter a paragraph or sentence:");
        String text = sc.nextLine();

        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String w : words) {
            if (!w.isEmpty()) {
                freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
            }
        }

        System.out.println("\n--- Word Frequency Occurrences ---");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
