import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        Method[] methods = suite.getClass().getDeclaredMethods();
        int count = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(Run.class)) {
                try {
                    m.invoke(suite);
                    count++;
                } catch (Exception e) {
                }
            }
        }
        System.out.println("Total @Run methods executed: " + count);
    }
}
