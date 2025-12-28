package generics;

public class Song {

    private String title;
    private int min;
    private GENRE genre;

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
}
