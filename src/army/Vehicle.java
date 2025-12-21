package army;

public abstract class Vehicle extends Unit {

    public int crew;

    public Vehicle(int id, String code, int crew) {
        super(id, code);
        this.crew = crew;
    }

    public abstract String drive();

}
