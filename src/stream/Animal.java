package stream;

public class Animal {

    private String name;
    private int lifeSpan;
    private double avgWeight;
    private boolean extinct;

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public Animal setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
        return this;
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public Animal setAvgWeight(double avgWeight) {
        this.avgWeight = avgWeight;
        return this;
    }

    public boolean isExtinct() {
        return extinct;
    }

    public Animal setExtinct(boolean extinct) {
        this.extinct = extinct;
        return this;
    }

    @Override
    public String toString() {
        String status = extinct ? "EXTINCT ☠" : "Alive";
        return String.format(
                "%-20s | %3d yrs | %7.1f kg | %s",
                name, lifeSpan, avgWeight, status
        );
    }
}
