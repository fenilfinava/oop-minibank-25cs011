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
