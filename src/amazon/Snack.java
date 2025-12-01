package amazon;

public class Snack extends Food {

    public Snack(String name, float price, int ingredients) {
        super(name, price, ingredients);
    }

    public void sugar() {
    }

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Snack!");
    }
}
