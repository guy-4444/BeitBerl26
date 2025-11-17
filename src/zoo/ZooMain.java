package zoo;

public class ZooMain {



    public static void start() {

        // Down casting
        Animal a1 = new Lion("Simba", 10);
        Lion l1 = (Lion) a1;
        ((Lion) a1).getLoudness();

        // Up casting
        Lion l2 = new Lion("Scar", 40);
        Animal a2 = (Animal) l2;
        a2.getAge();
        ((Animal) l2).getAge();
        l2.getAge();






        Animal[] animals = new Animal[] {
                new Penguin("Pini", 13, true),
                new Lion("Simba", 15),
                new Lion("Mufasa", 35),
                new EmperorPenguin("King", 50, false, 3),
                new Penguin("Pingi", 12, false),
                new Lion("Miki", 40),
                new Lion("Scar", 60),
        };

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
        System.out.println(" - - - - - - - - ");

        for (Animal a : animals) {
            if (a instanceof Penguin) {
                Penguin p = (Penguin) a;
                p.huntFish();
            }
        }

    }
}











