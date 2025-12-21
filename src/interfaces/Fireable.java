package interfaces;

public interface Fireable {

    void fire();

    default void stop() {
        int x = calculate();
    }

    private int calculate() {
        return 1;
    }

    static void stopAll() {
        stopAllHelper();
    }

    private static void stopAllHelper() {

    }

}
