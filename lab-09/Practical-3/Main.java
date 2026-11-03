// Practical: lab-09 - Practical-3 (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = 1;
        }

        ArraySum sum = new ArraySum();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) sum.add(data[i]);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 5000; i < 10000; i++) sum.add(data[i]);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Total array sum: " + sum.getTotal());
    }
}
