package test3;

public interface Battery extends Electric {
    void attach();

    @Override
    default void on() {
        // start charging
    }
}
