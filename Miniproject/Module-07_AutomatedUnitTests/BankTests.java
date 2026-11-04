// MiniProject - Module 7: Automated Unit Test Suite
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)

class TestAccount {
    private String accountNumber;
    private long balance;

    public TestAccount(String accNo, long balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public synchronized void deposit(long amt) {
        this.balance += amt;
    }

    public synchronized void withdraw(long amt) throws Exception {
        if (balance < amt) {
            throw new Exception("InsufficientFundsException: Shortfall of " + (amt - balance));
        }
        this.balance -= amt;
    }

    public synchronized long getBalance() { return balance; }
}

public class BankTests {
    public static void testDepositIncreasesBalance() {
        TestAccount acc = new TestAccount("T101", 1000);
        acc.deposit(500);
        if (acc.getBalance() != 1500) {
            throw new AssertionError("Test 1 Failed: Balance expected 1500, found " + acc.getBalance());
        }
        System.out.println("PASS: testDepositIncreasesBalance (Expected: 1500, Actual: " + acc.getBalance() + ")");
    }

    public static void testWithdrawOverLimitThrowsException() {
        TestAccount acc = new TestAccount("T102", 1000);
        boolean exceptionThrown = false;
        try {
            acc.withdraw(1500);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        if (!exceptionThrown) {
            throw new AssertionError("Test 2 Failed: Overdraft withdrawal did not throw exception!");
        }
        System.out.println("PASS: testWithdrawOverLimitThrowsException (Properly intercepted negative bound)");
    }

    public static void testConcurrentDepositsKeepBalanceCorrect() throws InterruptedException {
        TestAccount acc = new TestAccount("T103", 0);
        int threadCount = 10;
        int depositPerThread = 500;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    acc.deposit(depositPerThread);
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long expected = threadCount * 2 * depositPerThread;
        if (acc.getBalance() != expected) {
            throw new AssertionError("Test 3 Failed: Race condition detected! Expected " + expected + ", Actual " + acc.getBalance());
        }
        System.out.println("PASS: testConcurrentDepositsKeepBalanceCorrect (Synchronized Lock confirmed 10,000 balance)");
    }

    public static void runAll() {
        System.out.println("====================================================");
        System.out.println("  Module 7: Automated Unit Test Suite Execution");
        System.out.println("  Student: Fenil Jagdishbhai Finava (25CS011)");
        System.out.println("====================================================");
        try {
            testDepositIncreasesBalance();
            testWithdrawOverLimitThrowsException();
            testConcurrentDepositsKeepBalanceCorrect();
            System.out.println("\n----------------------------------------------------");
            System.out.println("SUMMARY: All MiniBank automated test cases PASSED (3/3)");
            System.out.println("----------------------------------------------------");
        } catch (Exception e) {
            System.out.println("FAILURE in test suite: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        runAll();
    }
}
