package hospital;

public abstract class Entity {

    public int id;
    private String token;

    public Entity(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public final void printTag() {
        System.out.println("Tag: " + id + ", " + token);
    }

    public abstract void getPosition();
    public abstract void move();
}
