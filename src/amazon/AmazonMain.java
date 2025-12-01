package amazon;

import utils.MermaidClassDiagramGenerator;

public class AmazonMain {

    public static void start() {

        try {
            String mermaid = MermaidClassDiagramGenerator.generateForClasses(
                    Laptop.class,
                    Honey.class,
                    Smartphone.class,
                    Electric.class,
                    Pc.class,
                    Table.class,
                    Product.class,
                    Wireless.class,
                    ProteinSnack.class,
                    Refrigerator.class,
                    Wired.class,
                    Food.class,
                    Snack.class
            );
            System.out.println(mermaid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Table t1 = new Table("Ikea coffee table", 100);
        Pc p1 = new Pc("Razer 1", 8000);
        Honey h1 = new Honey("Yad Mordechai", 30, 1);
        Snack a1 = new Snack("Tortit", 5, 8);
        ProteinSnack e1 = new ProteinSnack("Nature Valley", 15, 12);

        Laptop l = new Laptop("", 2);
        l.on();
//        System.out.println(t1.getName() + ": " + t1.getPrice());
//        System.out.println(p1.getName() + ": " + p1.getPrice());
//        System.out.println(h1.getName() + ": " + h1.getPrice());
//        System.out.println(a1.getName() + ": " + a1.getPrice());
//        System.out.println(e1.getName() + ": " + e1.getPrice());




    }

}
