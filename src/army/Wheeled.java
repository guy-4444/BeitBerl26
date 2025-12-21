package army;

public abstract class Wheeled extends Vehicle {

    public Wheeled(int id, String code, int crew) {
        super(id, code, crew);
    }

    @Override
    public String drive() {
        return "Driving!";
    }
}
