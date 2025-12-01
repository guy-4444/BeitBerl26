package amazon;

public class Laptop extends Wireless {

    public Laptop(String name, float price) {
        super(name, price);
    }

    public void openScreen() {}

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Laptop!");
    }
}
