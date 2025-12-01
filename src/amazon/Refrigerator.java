package amazon;

public class Refrigerator extends Wired {

    public Refrigerator(String name, float price) {
        super(name, price);
    }

    public void openDoor() {}

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Refrigerator!");
    }

    @Override
    void on() {

    }
}
