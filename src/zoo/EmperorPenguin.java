package zoo;

public class EmperorPenguin extends Penguin {

    private int lineWidth = 0;

    public EmperorPenguin(String name, int age, boolean hasEgg, int lineWidth) {
        super(name, age, hasEgg);
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public String toString() {
        return super.toString() + " + EmperorPenguin{" +
                "lineWidth=" + lineWidth +
                "}";
    }
}
