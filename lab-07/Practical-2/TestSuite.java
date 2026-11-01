public class TestSuite {
    @Run
    public void testA() {
        System.out.println("Executing testA");
    }

    public void helperMethod() {
        System.out.println("Helper not run");
    }

    @Run
    public void testB() {
        System.out.println("Executing testB");
    }
}
