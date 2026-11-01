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
