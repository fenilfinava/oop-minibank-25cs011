// Practical: lab-08 - Practical-3 (TestResource.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class TestResource implements AutoCloseable {
    private String name;
    // private data field encapsulation mate

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
