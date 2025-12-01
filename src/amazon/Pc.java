package amazon;

public class Pc extends Wired {

    public Pc(String name, float price) {
        super(name, price);
    }

    public void openGame() {}

    @Override
    public void on() {

    }

    @Override
    public float getPrice() {
        return super.getPrice() * 0.8f;
    }

    @Override
    public void notification() {
        System.out.println("Thanks for buying this PC!");
    }
}
