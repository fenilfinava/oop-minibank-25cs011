// Practical: lab-13 - Practical-1 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static <T> T first(T[] array) {
        return (array != null && array.length > 0) ? array[0] : null;
    }

    public static void main(String[] args) {
        Box<String> strBox = new Box<>();
        strBox.set("Hello Java");
        System.out.println("Box contents: " + strBox.get());

        Pair<String, Integer> p = new Pair<>("Age", 20);
        System.out.println("Pair: " + p.getFirst() + " = " + p.getSecond());

        Integer[] nums = { 10, 20, 30 };
        System.out.println("First element: " + first(nums));
    }
}
