package army;

import utils.MermaidClassDiagramGenerator;

public class ArmyMain {

    public void start() {

        Unit[] units = new Unit[] {
                new Rifleman(101, "S-101"),
                new Sniper(202, "S-202", 60),
                new Medic(303, "S-303", 3),
                new Tank(901, "V-901"),
                new APC(902, "V-902"),
                new Jeep(903, "V-903"),
                new Truck(904, "V-904")
        };

        for (Unit u : units) {
            u.printTag(); // final method in Unit
            System.out.println("HP=" + u.getHp() + " | " + u);
            if (u instanceof Soldier s) {
                System.out.println("Role=" + s.role());
            } else if (u instanceof Vehicle v) {
                System.out.println("Spec=" + v.drive());
            }
            System.out.println();
        }

//        Unit u = new Rifleman(1, "");
//        ((Tank) u).fire();



        String mermaid = MermaidClassDiagramGenerator.generateForClasses(true,
                APC.class,
                Jeep.class,
                Medic.class,
                Rifleman.class,
                Sniper.class,
                Soldier.class,
                Tank.class,
                Tracked.class,
                Truck.class,
                Unit.class,
                Vehicle.class,
                Wheeled.class
        );
        System.out.println(mermaid);
    }
}
