// Practical: lab-13 - Practical-2 (BoundedStats.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class BoundedStats {
    public static <N extends Number> double average(N[] values) {
        if (values == null || values.length == 0) return 0.0;
        double sum = 0.0;
        for (N v : values) {
            sum += v.doubleValue();
        }
        return sum / values.length;
    }

    public static void main(String[] args) {
        Integer[] intArr = { 10, 20, 30 };
        Double[] dblArr = { 5.5, 10.5, 15.0 };
        Long[] lngArr = { 100L, 200L, 300L };

        System.out.println("Integer average: " + average(intArr));
        System.out.println("Double average : " + average(dblArr));
        System.out.println("Long average   : " + average(lngArr));
    }
}
