package amazon;

public class Table extends Product {

    public Table(String name, float price) {
        super(name, price);
    }

    public void assemble() {}

    @Override
    public void notification() {
        System.out.println("Thanks for buying this Table!");
    }
}
