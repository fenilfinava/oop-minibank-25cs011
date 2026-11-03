// Practical: lab-09 - Practical-3 (ArraySum.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class ArraySum {
    private long total = 0;

    public synchronized void add(long val) {
        total += val;
    }

    public long getTotal() {
        return total;
    }
}
