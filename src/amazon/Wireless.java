package amazon;

public abstract class Wireless extends Electric {

    public Wireless(String name, float price) {
        super(name, price);
    }

    public void changeBattery() {}

    @Override
    void on() {

    }
}
