package restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RestApiMain {


    // gpt-5.2-mini
//                  "model": "gpt-4o-mini",
    //

    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public void start() {
        callApi();
        convert(responseJson);
    }

    private void callApi() {
        String apiKey = System.getenv("OPENAI_API_KEY");
        apiKey = "";
        if (apiKey == null) {
            throw new RuntimeException("OPENAI_API_KEY not set");
        }


//        "content": "Provide all the 15 major cities in Israel. Return ONLY valid JSON. For each city include name, population, district, short_description, area, neighbor cities, array of attractions and key points, local football teams, social-economic status. "

        String jsonBody =
                """
                {
                  "model": "gpt-5.2",
                  "messages": [
                    {
                      "role": "user",
                      "content": "give me random name starting with G"
                    }
                  ],
                  "temperature": 0.2
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(OPENAI_URL))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(response.body());



        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String content =
                root.path("choices")
                        .get(0)
                        .path("message")
                        .path("content")
                        .asText();

        // Optional: remove ```json ``` fences
        content = content
                .replaceAll("```json", "")
                .replaceAll("```", "")
                .trim();

        System.out.println(content);

        convert(responseJson);

    }

    private void convert(String json) {
        ArrayList<City> cities = getCities(json);
        System.out.println(cities.size());
    }

    private ArrayList<City> getCities(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Your JSON is an array: [ { ... }, { ... } ]
            List<City> list = mapper.readValue(json, new TypeReference<List<City>>() {});
            return new ArrayList<>(list);

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse cities JSON", e);
        }
    }




    public static final String responseJson = "[\n" +
            "  {\n" +
            "    \"name\": \"Jerusalem\",\n" +
            "    \"population\": 1000000,\n" +
            "    \"district\": \"Jerusalem District\",\n" +
            "    \"short_description\": \"Israel’s capital and largest city, a major religious, cultural, and governmental center.\",\n" +
            "    \"area_km2\": 125.1,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Ma'ale Adumim\",\n" +
            "      \"Beit Shemesh\",\n" +
            "      \"Mevaseret Zion\",\n" +
            "      \"Givat Ze'ev\",\n" +
            "      \"Bethlehem\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Old City (Western Wall, Church of the Holy Sepulchre, Al-Aqsa/Temple Mount)\",\n" +
            "      \"Yad Vashem\",\n" +
            "      \"Israel Museum\",\n" +
            "      \"Mahane Yehuda Market\",\n" +
            "      \"Knesset (Israeli Parliament)\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Beitar Jerusalem\",\n" +
            "      \"Hapoel Jerusalem\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Low-to-medium (citywide; significant internal variation)\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Tel Aviv-Yafo\",\n" +
            "    \"population\": 470000,\n" +
            "    \"district\": \"Tel Aviv District\",\n" +
            "    \"short_description\": \"Israel’s main economic and cultural hub, known for beaches, nightlife, and high-tech.\",\n" +
            "    \"area_km2\": 52.0,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Ramat Gan\",\n" +
            "      \"Givatayim\",\n" +
            "      \"Bnei Brak\",\n" +
            "      \"Holon\",\n" +
            "      \"Bat Yam\",\n" +
            "      \"Petah Tikva\",\n" +
            "      \"Herzliya\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Tel Aviv Promenade and beaches\",\n" +
            "      \"Jaffa Old City and Port\",\n" +
            "      \"Rothschild Boulevard (White City UNESCO area)\",\n" +
            "      \"Carmel Market\",\n" +
            "      \"Tel Aviv Museum of Art\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Maccabi Tel Aviv\",\n" +
            "      \"Hapoel Tel Aviv\",\n" +
            "      \"Bnei Yehuda Tel Aviv\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"High\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Haifa\",\n" +
            "    \"population\": 290000,\n" +
            "    \"district\": \"Haifa District\",\n" +
            "    \"short_description\": \"Major northern port city with mixed communities and a strong industrial and academic base.\",\n" +
            "    \"area_km2\": 63.7,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Nesher\",\n" +
            "      \"Tirat Carmel\",\n" +
            "      \"Kiryat Ata\",\n" +
            "      \"Kiryat Bialik\",\n" +
            "      \"Kiryat Motzkin\",\n" +
            "      \"Kiryat Yam\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Baháʼí Gardens (UNESCO)\",\n" +
            "      \"Stella Maris and Mount Carmel viewpoints\",\n" +
            "      \"German Colony\",\n" +
            "      \"Haifa Port\",\n" +
            "      \"Technion – Israel Institute of Technology\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Maccabi Haifa\",\n" +
            "      \"Hapoel Haifa\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rishon LeZion\",\n" +
            "    \"population\": 260000,\n" +
            "    \"district\": \"Central District\",\n" +
            "    \"short_description\": \"Large central city south of Tel Aviv, a major residential and commercial center.\",\n" +
            "    \"area_km2\": 58.7,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Holon\",\n" +
            "      \"Bat Yam\",\n" +
            "      \"Ness Ziona\",\n" +
            "      \"Rehovot\",\n" +
            "      \"Be'er Ya'akov\",\n" +
            "      \"Ramla\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Rishon LeZion Wine Cellars (Carmel/Mizrahi)\",\n" +
            "      \"Superland amusement park\",\n" +
            "      \"Old Rishon historic district\",\n" +
            "      \"Live Park (events venue)\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Rishon LeZion\",\n" +
            "      \"Maccabi Ironi Rishon LeZion\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium-to-high\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Petah Tikva\",\n" +
            "    \"population\": 260000,\n" +
            "    \"district\": \"Central District\",\n" +
            "    \"short_description\": \"One of Israel’s largest cities, a major employment center with hospitals and industry.\",\n" +
            "    \"area_km2\": 35.9,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Tel Aviv-Yafo\",\n" +
            "      \"Bnei Brak\",\n" +
            "      \"Ramat Gan\",\n" +
            "      \"Givat Shmuel\",\n" +
            "      \"Kiryat Ono\",\n" +
            "      \"Rosh HaAyin\",\n" +
            "      \"Hod HaSharon\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Rabin Medical Center (Beilinson/Hasharon hospitals)\",\n" +
            "      \"Petah Tikva Museum of Art\",\n" +
            "      \"Yad Labanim Park\",\n" +
            "      \"Industrial and high-tech zones (Kiryat Aryeh)\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Petah Tikva\",\n" +
            "      \"Maccabi Petah Tikva\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Ashdod\",\n" +
            "    \"population\": 230000,\n" +
            "    \"district\": \"Southern District\",\n" +
            "    \"short_description\": \"Major Mediterranean port city and industrial center in the south.\",\n" +
            "    \"area_km2\": 47.2,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Yavne\",\n" +
            "      \"Gan Yavne\",\n" +
            "      \"Ashkelon\",\n" +
            "      \"Kiryat Malakhi\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Port of Ashdod\",\n" +
            "      \"Ashdod Sea Promenade and beaches\",\n" +
            "      \"Ashdod Art Museum (Monart Centre)\",\n" +
            "      \"Tel Ashdod-Yam archaeological site\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"FC Ashdod\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Netanya\",\n" +
            "    \"population\": 230000,\n" +
            "    \"district\": \"Central District\",\n" +
            "    \"short_description\": \"Coastal city known for beaches, tourism, and growing residential neighborhoods.\",\n" +
            "    \"area_km2\": 29.0,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Herzliya\",\n" +
            "      \"Hadera\",\n" +
            "      \"Even Yehuda\",\n" +
            "      \"Kfar Yona\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Netanya beaches and promenade\",\n" +
            "      \"Poleg Nature Reserve\",\n" +
            "      \"Iris Reserve (seasonal bloom)\",\n" +
            "      \"Independence Square\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Maccabi Netanya\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Be'er Sheva\",\n" +
            "    \"population\": 220000,\n" +
            "    \"district\": \"Southern District\",\n" +
            "    \"short_description\": \"Largest city in the Negev and a key academic, medical, and tech hub for southern Israel.\",\n" +
            "    \"area_km2\": 117.5,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Omer\",\n" +
            "      \"Lehavim\",\n" +
            "      \"Meitar\",\n" +
            "      \"Rahat\",\n" +
            "      \"Tel Sheva\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Ben-Gurion University of the Negev\",\n" +
            "      \"Soroka Medical Center\",\n" +
            "      \"Old City and Turkish railway station area\",\n" +
            "      \"ANZAC Memorial and Be'er Sheva River Park\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Be'er Sheva\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Bnei Brak\",\n" +
            "    \"population\": 220000,\n" +
            "    \"district\": \"Tel Aviv District\",\n" +
            "    \"short_description\": \"Densely populated city adjacent to Tel Aviv, known as a major Haredi (ultra-Orthodox) center.\",\n" +
            "    \"area_km2\": 7.1,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Tel Aviv-Yafo\",\n" +
            "      \"Ramat Gan\",\n" +
            "      \"Givatayim\",\n" +
            "      \"Petah Tikva\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Haredi cultural and religious institutions\",\n" +
            "      \"Kahaneman Street commercial area\",\n" +
            "      \"Proximity to Tel Aviv metropolitan core\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Bnei Brak\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Low\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Holon\",\n" +
            "    \"population\": 200000,\n" +
            "    \"district\": \"Tel Aviv District\",\n" +
            "    \"short_description\": \"City south of Tel Aviv known for family attractions, design, and museums.\",\n" +
            "    \"area_km2\": 19.2,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Tel Aviv-Yafo\",\n" +
            "      \"Bat Yam\",\n" +
            "      \"Rishon LeZion\",\n" +
            "      \"Azor\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Israeli Children’s Museum\",\n" +
            "      \"Design Museum Holon\",\n" +
            "      \"Peres Park\",\n" +
            "      \"Mediatheque (theater and cultural complex)\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Holon\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Ramat Gan\",\n" +
            "    \"population\": 170000,\n" +
            "    \"district\": \"Tel Aviv District\",\n" +
            "    \"short_description\": \"Dense urban city east of Tel Aviv, home to major business districts and parks.\",\n" +
            "    \"area_km2\": 12.2,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Tel Aviv-Yafo\",\n" +
            "      \"Givatayim\",\n" +
            "      \"Bnei Brak\",\n" +
            "      \"Petah Tikva\",\n" +
            "      \"Kiryat Ono\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Diamond Exchange District\",\n" +
            "      \"Ramat Gan National Park\",\n" +
            "      \"Safari (Zoological Center Tel Aviv–Ramat Gan)\",\n" +
            "      \"Bar-Ilan University (adjacent in Ramat Gan area)\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hakoah Amidar Ramat Gan\",\n" +
            "      \"Hapoel Ramat Gan\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"High\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Ashkelon\",\n" +
            "    \"population\": 160000,\n" +
            "    \"district\": \"Southern District\",\n" +
            "    \"short_description\": \"Coastal city in the south with beaches, archaeology, and growing residential areas.\",\n" +
            "    \"area_km2\": 69.0,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Ashdod\",\n" +
            "      \"Sderot\",\n" +
            "      \"Kiryat Gat\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Ashkelon National Park (ancient ruins)\",\n" +
            "      \"Marina and beaches\",\n" +
            "      \"Barnea neighborhood viewpoints and coastline\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Ashkelon\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium-to-low\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rehovot\",\n" +
            "    \"population\": 150000,\n" +
            "    \"district\": \"Central District\",\n" +
            "    \"short_description\": \"Science-oriented city known for research institutes and a strong education sector.\",\n" +
            "    \"area_km2\": 26.8,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Ness Ziona\",\n" +
            "      \"Rishon LeZion\",\n" +
            "      \"Ramla\",\n" +
            "      \"Kiryat Ekron\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Weizmann Institute of Science\",\n" +
            "      \"Faculty of Agriculture (Hebrew University campus)\",\n" +
            "      \"Rehovot Science Park\",\n" +
            "      \"Minkov Citrus Orchard Museum\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Maccabi Rehovot\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"High\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Bat Yam\",\n" +
            "    \"population\": 130000,\n" +
            "    \"district\": \"Tel Aviv District\",\n" +
            "    \"short_description\": \"Coastal city south of Tel Aviv known for its beachfront and dense urban fabric.\",\n" +
            "    \"area_km2\": 8.2,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Tel Aviv-Yafo\",\n" +
            "      \"Holon\",\n" +
            "      \"Rishon LeZion\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Bat Yam promenade and beaches\",\n" +
            "      \"Bat Yam Amphitheater (events)\",\n" +
            "      \"Proximity to Jaffa and Tel Aviv\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Bat Yam\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"Medium-to-low\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Herzliya\",\n" +
            "    \"population\": 110000,\n" +
            "    \"district\": \"Tel Aviv District\",\n" +
            "    \"short_description\": \"Affluent coastal city north of Tel Aviv, known for high-tech and a marina.\",\n" +
            "    \"area_km2\": 26.0,\n" +
            "    \"neighbor_cities\": [\n" +
            "      \"Tel Aviv-Yafo\",\n" +
            "      \"Ramat HaSharon\",\n" +
            "      \"Hod HaSharon\",\n" +
            "      \"Ra'anana\",\n" +
            "      \"Netanya\"\n" +
            "    ],\n" +
            "    \"attractions_and_key_points\": [\n" +
            "      \"Herzliya Marina\",\n" +
            "      \"Herzliya beaches\",\n" +
            "      \"Herzliya Pituach high-tech and business area\",\n" +
            "      \"Apollonia National Park (Arsuf)\"\n" +
            "    ],\n" +
            "    \"local_football_teams\": [\n" +
            "      \"Hapoel Herzliya\"\n" +
            "    ],\n" +
            "    \"social_economic_status\": \"High\"\n" +
            "  }\n" +
            "]\n";
}