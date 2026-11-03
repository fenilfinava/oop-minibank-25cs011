// Practical: lab-07 - Practical-2 (TestSuite.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
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
