// Practical: lab-07 - Practical-2 (TestSuite.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class TestSuite {

    @Run
    public void testAuthentication() {
        System.out.println("  [RUNNING] -> testAuthentication(): User credentials verified successfully.");
    }

    // Aa method par @Run nathi etle reflection thi aa execute nahi thay
    public void helperSetupDatabase() {
        System.out.println("  [SKIPPED] -> helperSetupDatabase(): Database helper method.");
    }

    @Run
    public void testFundTransfer() {
        System.out.println("  [RUNNING] -> testFundTransfer(): Fund transfer transaction completed.");
    }

    public void internalCleanup() {
        System.out.println("  [SKIPPED] -> internalCleanup(): Cleanup routine.");
    }

    @Run
    public void testAccountStatement() {
        System.out.println("  [RUNNING] -> testAccountStatement(): Account statement generated.");
    }
}
