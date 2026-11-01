import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Student[] students = {
            new Student("Fenil", "25CS011", 1234),
            new Student("Aarav", "25CS012", 5678)
        };

        File file = new File("students.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(students);
        }

        Student[] loaded;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            loaded = (Student[]) ois.readObject();
        }
        file.delete();

        for (Student s : loaded) {
            System.out.println("Loaded: " + s);
        }
    }
}
