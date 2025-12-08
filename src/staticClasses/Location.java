package staticClasses;

public class Location {

    double lat;
    double lon;

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double distanceTo(double lat2, double lon2) {
        return Math.sqrt(this.lat - lat2 + this.lon - lon2);
    }

    public static double distanceBetween(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(lat1 - lat2 + lon1 - lon2);
    }
}
