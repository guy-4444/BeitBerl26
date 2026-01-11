package stream;

import staticClasses.A;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StreamMain {

    private ArrayList<Animal> animals = new ArrayList<>();

    public void start() {
        animals = DbGenerator.generate();



        ArrayList<Animal> arr = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.isExtinct()  &&  animal.getLifeSpan() > 14) {
                arr.add(animal);
            }
        }
        Collections.sort(arr, Comparator.comparingInt(value -> value.getLifeSpan()));
        // Collections.sort(arr, Comparator.comparingInt(Animal::getLifeSpan)); - Method reference

        ArrayList<Animal> arr2 = animals
                .parallelStream()
                .filter(animal -> animal.isExtinct())
                .filter(animal -> animal.getLifeSpan() > 14)
                .sorted((o1, o2) -> o1.getLifeSpan() - o2.getLifeSpan())
                .limit(5)
                .collect(Collectors.toCollection(ArrayList::new));



        printAll(arr2);
    }

    public void printAll(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

}
