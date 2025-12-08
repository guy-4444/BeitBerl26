package arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArraysMain {

    private String[] cities = new String[0];
    private int logicalSize = 0;

    public void start() {

        addCityExp("Tel Aviv");
        addCityExp("Ramat Gan");
        addCityExp("Jerusalem");
        addCityExp("Kfar Saba");
        addCityExp("Lod");

        System.out.println(Arrays.toString(cities));
        System.out.println("Length: " + cities.length);
    }

    private void addCityExp(String str) {
        if (logicalSize == cities.length) {
            int newSize = cities.length == 0 ? 1 : cities.length * 2;

            String[] temp = new String[newSize];

            for (int i = 0; i < cities.length; i++) {
                temp[i] = cities[i];
            }

            cities = temp;
        }

        cities[logicalSize] = str;
        logicalSize++;
    }

    private void addCity(String str) {
        int newSize = cities.length + 1;

        String[] temp = new String[newSize];

        for (int i = 0; i < cities.length; i++) {
            temp[i] = cities[i];
        }

        cities = temp;

        cities[cities.length - 1] = str;
    }

}
