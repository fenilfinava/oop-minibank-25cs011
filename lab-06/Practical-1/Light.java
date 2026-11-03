// Practical: lab-06 - Practical-1 (Light.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Light implements Switchable {
    private boolean lit = false;

    public void on() {
        lit = true;
        System.out.println("Light is turned ON");
    }

    public void off() {
        lit = false;
        System.out.println("Light is turned OFF");
    }

    public void toggle() {
        if (lit) off(); else on();
    }
}
