package army;

public class APC extends Tracked {

    public APC(int id, String code) {
        super(id, code, 2);
    }

    @Override
    public String drive() {
        return "APC: armored transport, crew=" + crew;
    }

    @Override
    public int getHp() {
        return 150;
    }
}
