// Practical: lab-06 - Practical-1 (Switchable.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public interface Switchable {
    void on();
    void off();
    default void toggle() {
        on();
    }
}
