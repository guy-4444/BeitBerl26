package army;

public class Rifleman extends Soldier {
    public Rifleman(int id, String code) {
        super(id, code);
    }

    @Override
    public String role() {
        return "Rifleman";
    }


}
