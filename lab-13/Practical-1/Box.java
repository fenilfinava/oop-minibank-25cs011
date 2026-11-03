// Practical: lab-13 - Practical-1 (Box.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
