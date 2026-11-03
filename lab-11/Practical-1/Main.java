// Practical 11 - Program 1: Object Serialization & Deserialization (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Java Object Serialization (Binary Stream) ===");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Roll No (e.g. 25CS011): ");
        String roll = sc.nextLine();
        System.out.print("Enter Security PIN (transient field): ");
        int pin = sc.nextInt();

        Student sOriginal = new Student(name, roll, pin);
        File file = new File("student.dat");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(sOriginal);
            System.out.println("\nSerialized Student to " + file.getName() + " successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Student sRestored = (Student) ois.readObject();
            System.out.println("Deserialized Object: " + sRestored);
            System.out.println("Notice that 'pin' is 0 because it was marked transient!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (file.exists()) file.deleteOnExit();
        }
    }
}
