package army;

public class Truck extends Wheeled {

    public Truck(int id, String code) {
        super(id, code, 2);
    }

    @Override
    public String drive() {
        return "Truck: cargo transport, crew=" + crew;
    }

    @Override
    public int getHp() {
        return 120;
    }

    public void load() {

    }

    public void unload() {

    }
}
