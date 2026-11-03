package layered.service;


// Practical: lab-14 - Practical-2/layered/service (ProductService.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import layered.model.Product;

public class ProductService {
    private ArrayList<Product> list = new ArrayList<>();

    public void add(Product p) {
        list.add(p);
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void save(Path file) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.toFile()))) {
            oos.writeObject(list);
        }
    }

    @SuppressWarnings("unchecked")
    public void load(Path file) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file.toFile()))) {
            list = (ArrayList<Product>) ois.readObject();
        }
    }
}
