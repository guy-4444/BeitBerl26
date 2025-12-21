package army;

public class Tank extends Tracked {

    public Tank(int id, String code) {
        super(id, code, 3);
    }

    @Override
    public String drive() {
        return "Tank: heavy armor, main gun, crew=" + crew;
    }

    @Override
    public int getHp() {
        return 200;
    }

    public void fire() {

    }
}
