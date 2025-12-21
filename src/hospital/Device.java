package hospital;

public abstract class Device extends Entity {

    public int price;

    public Device(int id, String token, int price) {
        super(id, token);
        this.price = price;
    }

    public abstract void on();
}
