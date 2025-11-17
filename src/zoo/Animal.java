package zoo;

public class Animal {

    private static int ID_COUNTER = 0;

    private int id;
    private String name = "";
    private int age;

    public Animal(String name, int age) {
        id = ++ID_COUNTER;
        setName(name);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            return;
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0) {
            this.age = 0;
            return;
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
