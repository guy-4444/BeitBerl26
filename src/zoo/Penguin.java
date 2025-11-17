package zoo;

public class Penguin extends Animal {

    private boolean hasEgg = false;

    public Penguin(String name, int age, boolean hasEgg) {
        super(name, age);
        this.hasEgg = hasEgg;
    }

    public void huntFish() {
        System.out.println(getName() + " ate fish!");
    }

    public boolean isHasEgg() {
        return hasEgg;
    }

    public void setHasEgg(boolean hasEgg) {
        this.hasEgg = hasEgg;
    }

    @Override
    public String toString() {
        return super.toString() + " + Penguin{" +
                "hasEgg=" + hasEgg +
                "}";
    }
}
