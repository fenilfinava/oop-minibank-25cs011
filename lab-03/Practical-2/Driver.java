// Practical 3 - Program 2: Card Equality (Interactive Input)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Playing Card Equality Checker ===");

        System.out.print("Enter Card 1 Rank (e.g. Ace, King, Queen): ");
        String r1 = sc.next();
        System.out.print("Enter Card 1 Suit (e.g. Spades, Hearts): ");
        String s1 = sc.next();
        Card c1 = new Card(r1, s1);

        System.out.print("Enter Card 2 Rank: ");
        String r2 = sc.next();
        System.out.print("Enter Card 2 Suit: ");
        String s2 = sc.next();
        Card c2 = new Card(r2, s2);

        System.out.println("\nCard 1: " + c1);
        System.out.println("Card 2: " + c2);

        if (c1.equals(c2)) {
            System.out.println("Result: Both cards are EQUAL! (Same rank and suit)");
        } else {
            System.out.println("Result: Cards are DIFFERENT.");
        }
        System.out.println("Card 1 HashCode: " + c1.hashCode() + " | Card 2 HashCode: " + c2.hashCode());
    }
}
