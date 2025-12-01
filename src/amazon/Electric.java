package amazon;

public abstract class Electric extends Product {

    public Electric(String name, float price) {
        super(name, price);
    }

    abstract void on();

}
