package layered.app;

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
