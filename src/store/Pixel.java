package store;

public class Pixel extends Android {

    public Pixel(String name, int amount, float price, int processors, int api) {
        super(name, amount, price, processors, api);
    }

    @Override
    public boolean canRoot() {
        return true;
    }

    @Override
    public void openApp() {

    }

    @Override
    public void call(String number) {
        super.call(number);
    }
}
