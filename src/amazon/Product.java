package amazon;

public abstract class Product {

    private String name;
    private float price;

    public Product(String name, float price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isBlank()) {
            return;
        }
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price <= 0.0) {
            return;
        }
        this.price = price;
    }

    public abstract void notification();

}
