// Practical: lab-14 - Practical-1 (Item.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Item {
    private String id;
    // private data field encapsulation mate
    private String name;
    // private data field encapsulation mate
    private double price;
    // private data field encapsulation mate

    public Item(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return id + " | " + name + " | Rs. " + price;
    }
}
