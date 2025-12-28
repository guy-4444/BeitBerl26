package generics;

public class Song implements Comparable<Song> {

    public String title;
    public int min;
    public GENRE genre;

    public Song(String title, int min, GENRE genre) {
        this.title = title;
        this.min = min;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title +
                ", min=" + min +
                ", genre=" + genre;
    }

    @Override
    public int compareTo(Song o) {
        return this.title.compareTo(o.title);
    }
}
