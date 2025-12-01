package amazon;

public class Smartphone extends Wireless {

    public Smartphone(String name, float price) {
        super(name, price);
    }

    public void call() {}

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Refrigerator!");
    }
}
