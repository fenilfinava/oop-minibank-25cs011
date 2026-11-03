package layered.model;


// Practical: lab-14 - Practical-2/layered/model (Product.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    // private data field encapsulation mate
    private String title;
    // private data field encapsulation mate

    public Product(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return code + ": " + title;
    }
}
