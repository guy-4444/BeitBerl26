package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListMain {

    private ArrayList<String> cities = new ArrayList<>();

    public void start() {

        cities.add("Tel Aviv");
        cities.add("Ramat Gan");
        cities.add("Jerusalem");
        cities.add("Kfar Saba");
        cities.add("Lod");

        cities.get(2); // gets Jerusalem
        cities.remove(3); // removes Kfar Saba
        cities.set(4, "Ramle");

        cities.add(new String(""));


        System.out.println(String.join(", ", cities));
        System.out.println("Length: " + cities.size());
    }


}
