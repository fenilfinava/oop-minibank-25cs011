public class TestResource implements AutoCloseable {
    private String name;

    public TestResource(String name) {
        this.name = name;
        System.out.println(name + " opened");
    }

    public void doWork(boolean fail) throws Exception {
        if (fail) {
            throw new Exception("Operation failed in " + name);
        }
        System.out.println(name + " working normally");
    }

    public void close() {
        System.out.println(name + " closed safely");
    }
}
