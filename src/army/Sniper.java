package army;

public class Sniper extends Soldier {
    private int focus; // 0..100

    public Sniper(int id, String code, int focus) {
        super(id, code);
        this.focus = focus;
    }

    @Override
    public String role() {
        return "Sniper";
    }

    public void fire() {

    }
}
