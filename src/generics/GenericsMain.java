package generics;

import java.util.ArrayList;

public class GenericsMain {

    public void start() {

        Song[] songs = {
                new Song("Neon Hearts", 3, GENRE.POP),
                new Song("Last Train Home", 4, GENRE.ROCK),
                new Song("Midnight Sax", 5, GENRE.JAZZ),
                new Song("Street Poetry", 3, GENRE.RAP),
                new Song("Pulse Driver", 4, GENRE.TECHNO),
                new Song("Summer Replay", 3, GENRE.POP),
                new Song("Guitar & Storm", 6, GENRE.ROCK),
                new Song("Blue", 6, GENRE.TECHNO),
                new Song("Blue Notes Cafe", 4, GENRE.JAZZ),
                new Song("Rhymes on Repeat", 2, GENRE.RAP),
                new Song("Synth City Lights", 5, GENRE.TECHNO)
        };

        IsraeliQueue<GENRE, Song> israeliQueue = new IsraeliQueue<>();
        israeliQueue.add(GENRE.RAP, new Song("A", 1, GENRE.RAP));
        israeliQueue.add(GENRE.ROCK, new Song("B", 1, GENRE.ROCK));
        israeliQueue.add(GENRE.JAZZ, new Song("C", 1, GENRE.JAZZ));
        israeliQueue.add(GENRE.RAP, new Song("D", 1, GENRE.RAP));
        israeliQueue.add(GENRE.ROCK, new Song("E", 1, GENRE.ROCK));
        israeliQueue.add(GENRE.JAZZ, new Song("F", 1, GENRE.JAZZ));
        israeliQueue.add(GENRE.RAP, new Song("G", 1, GENRE.RAP));
        israeliQueue.add(GENRE.ROCK, new Song("H", 1, GENRE.ROCK));
        israeliQueue.add(GENRE.JAZZ, new Song("I", 1, GENRE.JAZZ));

        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
        System.out.println(israeliQueue.pop());
    }


}
