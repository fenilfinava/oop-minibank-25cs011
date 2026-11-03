package layered.app;


// Practical: lab-14 - Practical-2/layered/app (Main.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.nio.file.Files;
import java.nio.file.Path;
import layered.model.Product;
import layered.service.ProductService;

public class Main {
    public static void main(String[] args) throws Exception {
        ProductService service = new ProductService();
        service.add(new Product("P101", "Keyboard"));
        service.add(new Product("P102", "Mouse"));

        Path tmp = Files.createTempFile("products_", ".dat");
        service.save(tmp);

        ProductService reloadedService = new ProductService();
        reloadedService.load(tmp);
        Files.deleteIfExists(tmp);

        System.out.println("Saved and reloaded products count: " + reloadedService.getList().size());
        for (Product p : reloadedService.getList()) {
            System.out.println("  " + p);
        }
    }
}
