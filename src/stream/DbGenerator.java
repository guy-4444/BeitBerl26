package stream;

import java.util.ArrayList;

public class DbGenerator {

    public static ArrayList<Animal> generate() {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Animal().setName("Elephant").setLifeSpan(70).setAvgWeight(5000).setExtinct(false));
        animals.add(new Animal().setName("Dog").setLifeSpan(13).setAvgWeight(20).setExtinct(false));
        animals.add(new Animal().setName("Cat").setLifeSpan(15).setAvgWeight(4.5).setExtinct(false));
        animals.add(new Animal().setName("Horse").setLifeSpan(30).setAvgWeight(500).setExtinct(false));
        animals.add(new Animal().setName("Cow").setLifeSpan(20).setAvgWeight(650).setExtinct(false));
        animals.add(new Animal().setName("Lion").setLifeSpan(14).setAvgWeight(190).setExtinct(false));
        animals.add(new Animal().setName("Tiger").setLifeSpan(16).setAvgWeight(220).setExtinct(false));
        animals.add(new Animal().setName("Giraffe").setLifeSpan(25).setAvgWeight(900).setExtinct(false));
        animals.add(new Animal().setName("Zebra").setLifeSpan(20).setAvgWeight(350).setExtinct(false));
        animals.add(new Animal().setName("Brown Bear").setLifeSpan(25).setAvgWeight(270).setExtinct(false));

        animals.add(new Animal().setName("Wolf").setLifeSpan(14).setAvgWeight(45).setExtinct(false));
        animals.add(new Animal().setName("Fox").setLifeSpan(10).setAvgWeight(7).setExtinct(false));
        animals.add(new Animal().setName("Rabbit").setLifeSpan(9).setAvgWeight(2.2).setExtinct(false));
        animals.add(new Animal().setName("Deer").setLifeSpan(18).setAvgWeight(120).setExtinct(false));
        animals.add(new Animal().setName("Goat").setLifeSpan(15).setAvgWeight(60).setExtinct(false));
        animals.add(new Animal().setName("Sheep").setLifeSpan(12).setAvgWeight(70).setExtinct(false));
        animals.add(new Animal().setName("Camel").setLifeSpan(40).setAvgWeight(600).setExtinct(false));
        animals.add(new Animal().setName("Kangaroo").setLifeSpan(23).setAvgWeight(55).setExtinct(false));
        animals.add(new Animal().setName("Chimpanzee").setLifeSpan(40).setAvgWeight(45).setExtinct(false));
        animals.add(new Animal().setName("Gorilla").setLifeSpan(35).setAvgWeight(160).setExtinct(false));

        animals.add(new Animal().setName("Leopard").setLifeSpan(17).setAvgWeight(60).setExtinct(false));
        animals.add(new Animal().setName("Cheetah").setLifeSpan(12).setAvgWeight(50).setExtinct(false));
        animals.add(new Animal().setName("Hyena").setLifeSpan(24).setAvgWeight(55).setExtinct(false));
        animals.add(new Animal().setName("Hippopotamus").setLifeSpan(45).setAvgWeight(1500).setExtinct(false));
        animals.add(new Animal().setName("Rhinoceros").setLifeSpan(50).setAvgWeight(2300).setExtinct(false));
        animals.add(new Animal().setName("Otter").setLifeSpan(16).setAvgWeight(10).setExtinct(false));
        animals.add(new Animal().setName("Badger").setLifeSpan(14).setAvgWeight(12).setExtinct(false));
        animals.add(new Animal().setName("Squirrel").setLifeSpan(8).setAvgWeight(0.6).setExtinct(false));
        animals.add(new Animal().setName("Moose").setLifeSpan(20).setAvgWeight(500).setExtinct(false));
        animals.add(new Animal().setName("Bison").setLifeSpan(25).setAvgWeight(900).setExtinct(false));

        animals.add(new Animal().setName("Dolphin").setLifeSpan(40).setAvgWeight(200).setExtinct(false));
        animals.add(new Animal().setName("Orca").setLifeSpan(50).setAvgWeight(5400).setExtinct(false));
        animals.add(new Animal().setName("Sea Turtle").setLifeSpan(80).setAvgWeight(150).setExtinct(false));
        animals.add(new Animal().setName("Crocodile").setLifeSpan(70).setAvgWeight(450).setExtinct(false));
        animals.add(new Animal().setName("Eagle").setLifeSpan(25).setAvgWeight(6).setExtinct(false));
        animals.add(new Animal().setName("Penguin").setLifeSpan(20).setAvgWeight(15).setExtinct(false));
        animals.add(new Animal().setName("Parrot").setLifeSpan(60).setAvgWeight(1.0).setExtinct(false));
        animals.add(new Animal().setName("Great White Shark").setLifeSpan(70).setAvgWeight(1100).setExtinct(false));
        animals.add(new Animal().setName("Polar Bear").setLifeSpan(22).setAvgWeight(450).setExtinct(false));
        animals.add(new Animal().setName("Giant Panda").setLifeSpan(20).setAvgWeight(100).setExtinct(false));

        // Extinct animals (for better stream exercises!)
        animals.add(new Animal().setName("Dodo").setLifeSpan(10).setAvgWeight(15).setExtinct(true));
        animals.add(new Animal().setName("Woolly Mammoth").setLifeSpan(60).setAvgWeight(6000).setExtinct(true));
        animals.add(new Animal().setName("Tasmanian Tiger").setLifeSpan(10).setAvgWeight(25).setExtinct(true));
        animals.add(new Animal().setName("Passenger Pigeon").setLifeSpan(15).setAvgWeight(0.35).setExtinct(true));
        animals.add(new Animal().setName("Great Auk").setLifeSpan(25).setAvgWeight(5).setExtinct(true));
        animals.add(new Animal().setName("Quagga").setLifeSpan(20).setAvgWeight(300).setExtinct(true));
        animals.add(new Animal().setName("Steller's Sea Cow").setLifeSpan(70).setAvgWeight(8000).setExtinct(true));
        animals.add(new Animal().setName("Saber-toothed Cat").setLifeSpan(15).setAvgWeight(200).setExtinct(true));
        animals.add(new Animal().setName("Moa").setLifeSpan(20).setAvgWeight(200).setExtinct(true));
        animals.add(new Animal().setName("Pyrenean Ibex").setLifeSpan(18).setAvgWeight(35).setExtinct(true));

        return animals;
    }
}
