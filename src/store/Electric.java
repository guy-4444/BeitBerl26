package store;

public abstract class Electric extends Product {


    public Electric(String name, int amount, float price) {
        super(name, amount, price);
    }

    public abstract void on();
}
