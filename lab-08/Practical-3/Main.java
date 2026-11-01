public class Main {
    public static void main(String[] args) {
        try (TestResource res = new TestResource("MyResource")) {
            res.doWork(true);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
