package queue;

public class Cat implements Comparable<Cat> {
    private String name;
    private int yrs;
    private int mnt;
    private int weight;


    public Cat(String name, int yrs, int mnt, int weight) {
        this.name = name;
        this.yrs = yrs;
        this.mnt = mnt;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public int getYrs() {
        return yrs;
    }

    public Cat setYrs(int yrs) {
        this.yrs = yrs;
        return this;
    }

    public int getMnt() {
        return mnt;
    }

    public Cat setMnt(int mnt) {
        this.mnt = mnt;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Cat setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return name + ": age=" + yrs + ", " + mnt + ", " + weight;
    }

    @Override
    public int compareTo(Cat other) {
        if (other.yrs != this.yrs) {
            return other.yrs - this.yrs;
        }

        return other.mnt - this.mnt;
    }
}
