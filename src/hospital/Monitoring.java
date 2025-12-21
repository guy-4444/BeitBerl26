package hospital;

public abstract class Monitoring extends Device {

    public Monitoring(int id, String token, int price) {
        super(id, token, price);
    }

    @Override
    public void on() {

    }
}
