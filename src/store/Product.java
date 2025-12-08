package store;

public abstract class Product {

    private String name;
    private int amount;
    private float price;

    public Product(String name, int amount, float price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
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

    public void increaseAmount(int value) {
        if (value < 0) {
            return;
        }
        this.amount += value;
    }

    public void reduceAmount(int value) {
        if (value < 0  ||  value > this.amount) {
            return;
        }
        this.amount -= value;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
