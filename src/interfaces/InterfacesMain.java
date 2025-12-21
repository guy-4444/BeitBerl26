package interfaces;

import interfaces.gate.GateMain;
import utils.MermaidClassDiagramGenerator;

public class InterfacesMain {

    public void start() {
        //generateDiagram();
        new GateMain().start();


    }

    private void generateDiagram() {
        MermaidClassDiagramGenerator.Options options = new MermaidClassDiagramGenerator.Options()
                .includeConstructors(false);

        String mermaid = MermaidClassDiagramGenerator.generateForClasses(options,
                Unit.class,
                Rifleman.class,
                Fireable.class,
                Tank.class,
                Land.class,
                AutoFireable.class,
                Sniper.class
        );
        System.out.println(mermaid);
    }
}
