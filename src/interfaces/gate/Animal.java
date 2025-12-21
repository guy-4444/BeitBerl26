package interfaces.gate;

public abstract class Animal implements Soundable {

    private String name;
    private String sound;



    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getSound() {
        return sound;
    }

    public Animal setSound(String sound) {
        this.sound = sound;
        return this;
    }

    @Override
    public void makeSound() {
        if (sound != null) {
            System.out.println("    " + name + "(" + getClass().getSimpleName() + ") making sound: " + sound);
        } else {
            System.out.println("    " + name + "(" + getClass().getSimpleName() + ") is silent");
        }
    }
}
