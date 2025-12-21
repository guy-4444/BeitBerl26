package map;

public class Game {

    public enum GENRE {
        ACTION,
        TYCOON,
        PUZZLE,
        PLATFORM,
    }

    private String code;
    private String name;
    private GENRE genre;
    private int releaseYear;
    private boolean isOnline = false;

    public Game(String code) {
        this.code = code;
    }

    public Game(String code, String name, GENRE genre, int releaseYear, boolean isOnline) {
        this.code = code;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.isOnline = isOnline;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public GENRE getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public Game setName(String name) {
        this.name = name;
        return this;
    }

    public Game setGenre(GENRE genre) {
        this.genre = genre;
        return this;
    }

    public Game setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public Game setOnline(boolean online) {
        isOnline = online;
        return this;
    }
}
