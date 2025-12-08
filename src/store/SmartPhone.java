package store;

public abstract class SmartPhone extends Phone {

    private int processors;

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    public SmartPhone(String name, int amount, float price, int processors) {
        super(name, amount, price);
        this.processors = processors;
    }

    public abstract void openApp();
}
