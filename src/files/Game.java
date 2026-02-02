package files;

import java.util.Locale;

public class Game {
    private final String name;
    private final int releaseYear;
    private final String genre;
    private final long numOfDownloads;
    private final double rating; // 0.0 - 5.0

    public Game(String name, int releaseYear, String genre, long numOfDownloads, double rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.numOfDownloads = numOfDownloads;
        this.rating = rating;
    }

    public String getName() { return name; }
    public int getReleaseYear() { return releaseYear; }
    public String getGenre() { return genre; }
    public long getNumOfDownloads() { return numOfDownloads; }
    public double getRating() { return rating; }

    // CSV line with US-locale decimal point + newline
    public String toCsvLine() {
        return String.format(Locale.US, "%s, %d, %s, %d, %.1f%n",
                name, releaseYear, genre, numOfDownloads, rating);
    }

    // Optional: parse from CSV line
    public static Game fromCsvLine(String line) {
        // expecting: name, year, genre, downloads, rating
        String[] p = line.split(",");
        if (p.length != 5) throw new IllegalArgumentException("Bad CSV line: " + line);

        String name = p[0].trim();
        int year = Integer.parseInt(p[1].trim());
        String genre = p[2].trim();
        long downloads = Long.parseLong(p[3].trim());

        // Use dot-decimal; if someone wrote "4,5" by mistake this will fail (good for teaching)
        double rating = Double.parseDouble(p[4].trim());

        return new Game(name, year, genre, downloads, rating);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s (%d) | %s | %,d downloads | %.1f/5",
                name, releaseYear, genre, numOfDownloads, rating);
    }
}
