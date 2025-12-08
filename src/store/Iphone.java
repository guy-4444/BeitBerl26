package store;

public class Iphone extends SmartPhone {

    public Iphone(String name, int amount, float price, int processors) {
        super(name, amount, price, processors);
    }

    @Override
    public void openApp() {

    }

    @Override
    public void call(String number) {
        super.call(number);
    }
}
