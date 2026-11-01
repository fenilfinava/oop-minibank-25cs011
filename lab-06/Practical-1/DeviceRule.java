@FunctionalInterface
public interface DeviceRule {
    boolean allow(Switchable device, int hour);
}
