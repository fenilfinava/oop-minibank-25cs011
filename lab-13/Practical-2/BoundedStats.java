// Practical 13 - Program 2: Bounded Generic Method <N extends Number> (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;

public class BoundedStats {
    public static <N extends Number> double average(N[] values) {
        if (values == null || values.length == 0) return 0.0;
        double sum = 0.0;
        for (N v : values) sum += v.doubleValue();
        return sum / values.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Bounded Type Generics Average Calculator ===");

        System.out.print("How many Integer numbers? ");
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        double avg = average(nums);
        System.out.printf("Computed Average via <N extends Number>: %.2f%n", avg);
    }
}
