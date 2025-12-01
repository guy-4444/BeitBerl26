package amazon;

public abstract class Wired extends Electric {

    public Wired(String name, float price) {
        super(name, price);
    }

    public void connect() {}

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Wired!");
    }
}
