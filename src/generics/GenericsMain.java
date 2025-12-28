package generics;

import java.util.ArrayList;

public class GenericsMain {

    public void start() {
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
