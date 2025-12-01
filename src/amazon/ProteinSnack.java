package amazon;

public class ProteinSnack extends Snack {

    public ProteinSnack(String name, float price, int ingredients) {
        super(name, price, ingredients);
    }

    public void powerBoost() {
    }

    @Override
    public float getPrice() {
        return super.getPrice() * (2.0f / 3.0f);
    }

    @Override
    public void notification() {
        super.notification();
    }
}
