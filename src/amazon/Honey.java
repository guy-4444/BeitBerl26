package amazon;

public class Honey extends Food {

    public Honey(String name, float price, int ingredients) {
        super(name, price, ingredients);
    }

    public void flowerType() {}

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Honey!");
    }
}
