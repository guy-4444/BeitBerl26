package garage;

public class Car {

    public static int NUM_OF_CARS = 0;

    private String model;
    private int km;

    public Car() {
        NUM_OF_CARS++;
        setModel("NA");
        setKm(0);
    }

    public Car(String model) {
        NUM_OF_CARS++;
        setModel(model);
        setKm(0);
    }

    public Car(String model, int km) {
        NUM_OF_CARS++;
        setModel(model);
        setKm(km);
    }

    private void setModel(String model) {
        if (model.isEmpty()) {
            System.out.println("Model name is empty!");
            this.model = "NA";
            return;
        }

        this.model = model;
    }

    public String getModel() {
        return model;
    }


    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        if (km < 0) {
            System.out.println("Negative");
            return;
        }

        if (km < this.km) {
            System.out.println("Kombina");
            return;
        }

        this.km = km;
    }

    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", km=" + km +
                '}';
    }
}
