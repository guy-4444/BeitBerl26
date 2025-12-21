package army;

public class Medic extends Soldier {

    private int medKits;

    public Medic(int id, String code, int medKits) {
        super(id, code);
        this.medKits = Math.max(0, medKits);
    }

    @Override
    public String role() {
        return "Medic";
    }

    public boolean heal(Soldier target) {
        if (medKits <= 0) return false;
        medKits--;
        // Example "heal": just let the soldier rest once.
        target.rest();
        return true;
    }
}
