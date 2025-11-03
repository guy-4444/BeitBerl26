package garage;

public class GarageMain {

    public static void start() {

        Car c1 = new Car("Mercedes");
        c1.setKm(300000);
        System.out.println(c1);

        Car c2 = new Car("Mitsubishi");
        c2.setKm(50000);
        System.out.println(c2);

        Car c3 = new Car("");
        System.out.println(c3);

        Car c4 = new Car("Porsche 911", 8000);
        System.out.println(c4);

        Car c5 = new Car();
        System.out.println(c5);

        System.out.println(Car.NUM_OF_CARS);

    }
}
