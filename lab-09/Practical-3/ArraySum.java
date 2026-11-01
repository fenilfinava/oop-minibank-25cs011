public class ArraySum {
    private long total = 0;

    public synchronized void add(long val) {
        total += val;
    }

    public long getTotal() {
        return total;
    }
}
