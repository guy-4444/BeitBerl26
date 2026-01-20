package restapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private String name;
    private int population;
    private String district;

    @JsonProperty("short_description")
    private String shortDescription;

    @JsonProperty("area_km2")
    private double areaKm2;

    @JsonProperty("neighbor_cities")
    private List<String> neighborCities;

    @JsonProperty("attractions_and_key_points")
    private List<String> attractionsAndKeyPoints;

    @JsonProperty("local_football_teams")
    private List<String> localFootballTeams;

    @JsonProperty("social_economic_status")
    private String socialEconomicStatus;

    // --- Getters/Setters (Jackson needs them unless you use records) ---

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public double getAreaKm2() { return areaKm2; }
    public void setAreaKm2(double areaKm2) { this.areaKm2 = areaKm2; }

    public List<String> getNeighborCities() { return neighborCities; }
    public void setNeighborCities(List<String> neighborCities) { this.neighborCities = neighborCities; }

    public List<String> getAttractionsAndKeyPoints() { return attractionsAndKeyPoints; }
    public void setAttractionsAndKeyPoints(List<String> attractionsAndKeyPoints) { this.attractionsAndKeyPoints = attractionsAndKeyPoints; }

    public List<String> getLocalFootballTeams() { return localFootballTeams; }
    public void setLocalFootballTeams(List<String> localFootballTeams) { this.localFootballTeams = localFootballTeams; }

    public String getSocialEconomicStatus() { return socialEconomicStatus; }
    public void setSocialEconomicStatus(String socialEconomicStatus) { this.socialEconomicStatus = socialEconomicStatus; }
}
