package hospital;

public abstract class Person extends Entity {

    public Person(int id, String token) {
        super(id, token);
    }

    public abstract void getSalary();

    @Override
    public void move() {

    }
}
