package store;

public abstract class Computer extends Electric {

    int processors;

    public Computer(String name, int amount, float price, int processors) {
        super(name, amount, price);
        this.processors = processors;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    @Override
    public void on() {

    }
}
