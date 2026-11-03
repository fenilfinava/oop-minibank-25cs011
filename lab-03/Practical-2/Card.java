// Practical: lab-03 - Practical-2 (Card.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.util.Objects;

public class Card {
    private String rank;
    // private data field encapsulation mate
    private String suit;
    // private data field encapsulation mate

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(rank, card.rank) && Objects.equals(suit, card.suit);
    }

    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
