package generics;

import army.Soldier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingMain {

    public void start() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Neon Hearts", 3, GENRE.POP));
        songs.add(new Song("Last Train Home", 4, GENRE.ROCK));
        songs.add(new Song("Midnight Sax", 5, GENRE.JAZZ));
        songs.add(new Song("Street Poetry", 3, GENRE.RAP));
        songs.add(new Song("Pulse Driver", 4, GENRE.TECHNO));
        songs.add(new Song("Summer Replay", 3, GENRE.POP));
        songs.add(new Song("Guitar & Storm", 7, GENRE.ROCK));
        songs.add(new Song("Blue", 6, GENRE.TECHNO));
        songs.add(new Song("Blue Notes Cafe", 4, GENRE.JAZZ));
        songs.add(new Song("Rhymes on Repeat", 2, GENRE.RAP));
        songs.add(new Song("Synth City Lights", 5, GENRE.TECHNO));


        Collections.sort(songs, new Comparator<>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.min - o2.min;
            }
        });

        //printAll(songs);


        ArrayList<String> singers = new ArrayList<>();
        singers.add("Taylor Swift");
        singers.add("Adele");
        singers.add("Ed Sheeran");
        singers.add("Beyoncé");
        singers.add("Drake");
        singers.add("Bruno Mars");
        singers.add("Rihanna");
        singers.add("The Weeknd");
        singers.add("Billie Eilish");
        singers.add("Justin Bieber");



        Collections.sort(singers, (o1, o2) -> o1.length() - o2.length());
        Collections.sort(singers, Comparator.comparingInt(String::length));
        printAll(singers);
    }

    private <T> void printAll(ArrayList<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
