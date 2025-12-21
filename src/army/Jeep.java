package army;

public class Jeep extends Wheeled {

    public static final String MANUFACTURER = "HUMMER";

    public Jeep(int id, String code) {
        super(id, code, 2);
    }

    @Override
    public String drive() {
        return "Jeep: light transport, crew=" + crew;
    }

    @Override
    public int getHp() {
        return 90;
    }

    public static String getManufacturer() {
        return MANUFACTURER;
    }
}
