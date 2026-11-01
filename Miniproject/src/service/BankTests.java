package service;

import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import model.SavingsAccount;

public class BankTests {
    public static void testDepositIncreasesBalance() throws Exception {
        SavingsAccount acc = new SavingsAccount("TestUser", 1000, 500);
        acc.deposit(500);
        if (acc.getBalance() != 1500) {
            throw new AssertionError("Deposit failed to increase balance correctly");
        }
        System.out.println("PASS: testDepositIncreasesBalance");
    }

    public static void testWithdrawOverLimitThrowsException() {
        SavingsAccount acc = new SavingsAccount("TestUser", 1000, 500);
        boolean caught = false;
        try {
            acc.withdraw(800);
        } catch (InsufficientFundsException e) {
            caught = true;
        } catch (Exception e) {
        }
        if (!caught) {
            throw new AssertionError("Expected InsufficientFundsException not thrown");
        }
        System.out.println("PASS: testWithdrawOverLimitThrowsException");
    }

    public static void testConcurrentDepositsKeepBalanceCorrect() throws Exception {
        SavingsAccount acc = new SavingsAccount("ThreadTest", 0, 0);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new AccountWorker(acc, 500, 2));
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        if (acc.getBalance() != 10000) {
            throw new AssertionError("Concurrent deposits resulted in wrong balance: " + acc.getBalance());
        }
        System.out.println("PASS: testConcurrentDepositsKeepBalanceCorrect");
    }

    public static void runAll() {
        try {
            testDepositIncreasesBalance();
            testWithdrawOverLimitThrowsException();
            testConcurrentDepositsKeepBalanceCorrect();
            System.out.println("All MiniBank unit tests passed successfully.");
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}
