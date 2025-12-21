package army;

public abstract class Soldier extends Unit {
    public int stamina; // 0..100

    public Soldier(int id, String code) {
        super(id, code);
        this.stamina = 100;
    }

    public void rest() {
        stamina = Math.min(100, stamina + 10);
    }

    public abstract String role();

    @Override
    public int getHp() {
        return 100;
    }

    public void fire() {

    }
}
