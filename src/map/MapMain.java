package map;

import zoo.Animal;
import zoo.EmperorPenguin;
import zoo.Lion;
import zoo.Penguin;

import java.util.HashMap;

public class MapMain {

    public static void start() {

        HashMap<String, Game> map = new HashMap<>();


        map.put("aoe3", new Game("aoe3")
                .setName("Age of empires 3")
                .setGenre(Game.GENRE.TYCOON)
                .setReleaseYear(2001)
                .setOnline(true));

        map.put("tpp", new Game("tpp")
                .setName("The persian prince")
                .setGenre(Game.GENRE.PLATFORM)
                .setReleaseYear(1989));


        Game g = map.get("tpp");
        System.out.println(g);




    }
}











