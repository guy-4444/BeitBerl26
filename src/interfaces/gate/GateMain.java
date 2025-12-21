package interfaces.gate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GateMain {

    private HashMap<String, ArrayList<Animal>> animalMap;

    public void start() {

        generateAnimals();
        Gate.GateListener listener = new Gate.GateListener() {
            @Override
            public void opened() {
                gate_open();
            }

            @Override
            public void closed() {
                gate_close();
            }
        };
        Gate gate = new Gate();
        gate.setListener(listener);
        gate.startGate();



        ArrayList<Animal> animals = new ArrayList<>();
    }

    private void generateAnimals() {
        animalMap = new HashMap<>();
        animalMap.put("sheeps", new ArrayList<>());
        animalMap.put("lions", new ArrayList<>());
        animalMap.put("fish", new ArrayList<>());
        animalMap.get("sheeps").add(new Sheep("Dolly", "Meeee"));
        animalMap.get("lions").add(new Lion("Simba", "arrr"));
        animalMap.get("lions").add(new Lion("Scar", "grrrr"));
        animalMap.get("fish").add(new Goldfish("Nemo"));
    }

    private void gate_close() {
        //
    }

    private void gate_open() {
        for (Map.Entry<String, ArrayList<Animal>> entry : animalMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Animal animal : entry.getValue()) {
                animal.makeSound();
            }
        }
    }
}
