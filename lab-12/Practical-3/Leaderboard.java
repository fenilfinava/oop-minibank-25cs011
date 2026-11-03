// Practical 12 - Program 3: Tournament Leaderboard (TreeMap) (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;

public class Leaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Tournament Ranked Leaderboard (TreeMap) ===");

        TreeMap<Integer, String> board = new TreeMap<>(Collections.reverseOrder());

        System.out.print("How many player scores do you want to add? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Player " + i + " Name & Score (e.g. Fenil 950): ");
            String name = sc.next();
            int score = sc.nextInt();
            board.put(score, name);
        }

        System.out.println("\n=== Official Standings (Ranked High to Low) ===");
        int rank = 1;
        for (Map.Entry<Integer, String> entry : board.entrySet()) {
            System.out.println("Rank " + (rank++) + ": " + entry.getValue() + " -> " + entry.getKey() + " pts");
        }
    }
}
