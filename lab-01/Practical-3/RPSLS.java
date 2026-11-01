import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    public static int winner(Move a, Move b) {
        if (a == b) {
            return 0;
        }
        boolean aWins = switch (a) {
            case ROCK -> (b == Move.SCISSORS || b == Move.LIZARD);
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK);
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD);
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER);
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK);
        };
        return aWins ? 1 : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Move[] moves = Move.values();
        int userScore = 0;
        int compScore = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Round " + i + " - Enter move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            String in = sc.next().toUpperCase();
            Move playerMove = Move.valueOf(in);
            Move compMove = moves[rand.nextInt(moves.length)];

            int res = winner(playerMove, compMove);
            System.out.println("You played: " + playerMove + ", Computer played: " + compMove);
            if (res == 1) {
                userScore++;
                System.out.println("You win round " + i);
            } else if (res == -1) {
                compScore++;
                System.out.println("Computer wins round " + i);
            } else {
                System.out.println("Round " + i + " is a tie");
            }
        }

        System.out.println("Summary: You " + userScore + " - " + compScore + " Computer");
        if (userScore > compScore) {
            System.out.println("Overall Winner: You");
        } else if (compScore > userScore) {
            System.out.println("Overall Winner: Computer");
        } else {
            System.out.println("Overall Result: Tie");
        }
    }
}
