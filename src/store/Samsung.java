package store;

public class Samsung extends Android {

    public Samsung(String name, int amount, float price, int processors, int api) {
        super(name, amount, price, processors, api);
    }

    @Override
    public boolean canRoot() {
        return false;
    }

    @Override
    public void openApp() {

    }

    @Override
    public void call(String number) {
        super.call(number);
    }
}
