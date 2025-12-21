package army;

public abstract class Unit {

    public int id;
    private String code;

    public Unit(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public abstract int getHp();

    /**
     * Final function: cannot be overridden.
     */
    public final void printTag() {
        System.out.println("[UnitTag] id=" + id + ", code=" + code + ", type=" + getClass().getSimpleName());
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + ", code=" + code + ", hp=" + getHp() + "}";
    }
}
