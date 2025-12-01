package amazon;

public abstract class Food extends Product {

    protected int ingredients;

    public Food(String name, float price, int ingredients) {
        super(name, price);
        setIngredients(ingredients);
    }

    public int getIngredients() {
        return ingredients;
    }

    public void setIngredients(int ingredients) {
        if (ingredients <= 0) {
            return;
        }
        this.ingredients = ingredients;
    }

    @Override
    public float getPrice() {
        return super.getPrice() * 0.9f;
    }
}
