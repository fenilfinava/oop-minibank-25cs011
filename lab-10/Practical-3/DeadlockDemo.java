// Practical: lab-10 - Practical-3 (DeadlockDemo.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class DeadlockDemo {
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding Lock1...");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding Lock1 & Lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Thread 2: Holding Lock1...");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (Lock2) {
                    System.out.println("Thread 2: Holding Lock1 & Lock2");
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Consistent lock ordering executed without deadlock.");
    }
}
