// Practical: lab-06 - Practical-1 (Fan.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class Fan implements Switchable {
    private boolean running = false;

    public void on() {
        running = true;
        System.out.println("Fan is turned ON");
    }

    public void off() {
        running = false;
        System.out.println("Fan is turned OFF");
    }

    public void toggle() {
        if (running) off(); else on();
    }
}
