package service;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import exception.BankException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;
import java.util.Queue;
import model.Account;

public class TransactionProcessor {
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private final Queue<Runnable> taskQueue = new LinkedList<>();
    private final int capacity = 10;
    private final ConcurrentHashMap<String, Account> sharedAccounts = new ConcurrentHashMap<>();

    public void registerAccount(Account acc) {
        sharedAccounts.put(acc.getAccountNumber(), acc);
    }

    public Account getSharedAccount(String accNo) {
        return sharedAccounts.get(accNo);
    }

    public void submit(Runnable task) {
        pool.execute(task);
    }

    public synchronized void enqueue(Runnable task) throws InterruptedException {
        while (taskQueue.size() >= capacity) {
            wait();
        }
        taskQueue.add(task);
        notifyAll();
    }

    public synchronized Runnable dequeue() throws InterruptedException {
        while (taskQueue.isEmpty()) {
            wait();
        }
        Runnable task = taskQueue.poll();
        notifyAll();
        return task;
    }

    public static void transferSafe(Account from, Account to, long amount) throws BankException {
        Account first = from.getAccountNumber().compareTo(to.getAccountNumber()) < 0 ? from : to;
        Account second = first == from ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Safe transfer completed: " + from.getAccountNumber() + " -> " + to.getAccountNumber() + " Rs. " + amount);
            }
        }
    }

    public void stop() {
        pool.shutdown();
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
    }
}
