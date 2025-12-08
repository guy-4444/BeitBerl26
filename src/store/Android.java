package store;

public abstract class Android extends SmartPhone {

    private int api;

    public Android(String name, int amount, float price, int processors, int api) {
        super(name, amount, price, processors);
        this.api = api;
    }

    public abstract boolean canRoot();

    @Override
    public void openApp() {

    }
}
