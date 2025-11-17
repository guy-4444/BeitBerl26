package zoo;

public class Lion extends Animal {

    private int loudness;

    public Lion(String name, int age) {
        super(name, age);
        this.loudness = 0;
    }

    public Lion(String name, int age, int loudness) {
        super(name, age);
        this.loudness = loudness;
    }

    public int getLoudness() {
        return loudness;
    }

    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }

    @Override
    public String toString() {
        return super.toString() + " + Lion{" +
                "loudness=" + loudness +
                "}";
    }
}
