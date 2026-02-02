package files;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static restapi.RestApiMain.responseJson;

public class MyFileCreator {

    private static final String FILE_PATH = "/Users/guymacin/Downloads/MyGame/games_table.csv";

    public void start() {
        Locale.setDefault(Locale.ITALY);

        String data = "Cuba was inhabited as early as the 4th millennium BC, with the Guanahatabey and Taíno peoples present at the time of Spanish colonization in the 15th century.";

        ArrayList<Game> games2 = new ArrayList<>(List.of(
                new Game("Minecraft", 2011, "Sandbox", 300_000_000L, 4.33333333),
                new Game("Fortnite", 2017, "Battle Royale", 500_000_000L, 4.1234567),
                new Game("Among Us", 2018, "Party", 200_000_000L, 4.14792),
                new Game("GTA V", 2013, "Action", 190_000_000L, 4.7),
                new Game("The Witcher 3", 2015, "RPG", 50_000_000L, 4.9),
                new Game("League of Legends", 2009, "MOBA", 180_000_000L, 4.2),
                new Game("Valorant", 2020, "FPS", 50_000_000L, 4.4),
                new Game("Roblox", 2006, "Platform", 500_000_000L, 4.0),
                new Game("Candy Crush Saga", 2012, "Puzzle", 1_000_000_000L, 4.5),
                new Game("Clash of Clans", 2012, "Strategy", 500_000_000L, 4.6),
                new Game("PUBG: Battlegrounds", 2017, "Battle\nRoyale", 200_000_000L, 4.1),
                new Game("Call of Duty:Mobile", 2019, "FPS", 500_000_000L, 4.4),
                new Game("Pokémon, GO", 2016, "AR", 1_000_000_000L, 4.2),
                new Game("Subway Surfers", 2012, "Endless Runner", 3_000_000_000L, 4.6),
                new Game("Temple Run", 2011, "Endless Runner", 1_000_000_000L, 4.3),
                new Game("Hades", 2020, "Roguelike", 10_000_000L, 4.9),
                new Game("Stardew Valley", 2016, "Simulation", 30_000_000L, 4.8),
                new Game("Rocket League", 2015, "Sports", 90_000_000L, 4.5),
                new Game("Forza Horizon 5", 2021, "Racing", 30_000_000L, 4.7),
                new Game("The Sims 4", 2014, "Simulation", 70_000_000L, 4.2)
        ));

        ArrayList<Game> games = new ArrayList<>(List.of(
                new Game("מיינקראפט", 2011, "סנדבוקס", 300_000_000L, 4.8),
                new Game("פורטנייט", 2017, "באטל רויאל", 500_000_000L, 4.3),
                new Game("אמונג \uD83D\uDE03  אס", 2018, "מסיבות", 200_000_000L, 4.1),
                new Game("GTA V", 2013, "אקשן", 190_000_000L, 4.7),
                new Game("המכשף 3", 2015, "תפקידים (RPG)", 50_000_000L, 4.9),
                new Game("ליג אוף לג'נדס", 2009, "זירה (MOBA)", 180_000_000L, 4.2),
                new Game("ולרנט", 2020, "יריות (FPS)", 50_000_000L, 4.4),
                new Game("רובלוקס", 2006, "פלטפורמה", 500_000_000L, 4.0),
                new Game("קאדי קראש סאגה", 2012, "פאזל", 1_000_000_000L, 4.5),
                new Game("קלאש אוף קלאנס", 2012, "אסטרטגיה", 500_000_000L, 4.6),
                new Game("פאבג'י", 2017, "באטל רויאל", 200_000_000L, 4.1),
                new Game("Call of Duty: Mobile", 2019, "יריות (FPS)", 500_000_000L, 4.4),
                new Game("פוקימון גו", 2016, "מציאות רבודה (AR)", 1_000_000_000L, 4.2),
                new Game("סאבווי סרפרס", 2012, "ריצה אינסופית", 3_000_000_000L, 4.6),
                new Game("טמפל ראן", 2011, "ריצה אינסופית", 1_000_000_000L, 4.3),
                new Game("האדס", 2020, "רוגלייק", 10_000_000L, 4.9),
                new Game("סטארדיו ואלי", 2016, "סימולציה", 30_000_000L, 4.8),
                new Game("רוקט ליג", 2015, "ספורט", 90_000_000L, 4.5),
                new Game("פורצה הורייזון 5", 2021, "מירוצים", 30_000_000L, 4.7),
                new Game("הסימס 4", 2014, "סימולציה", 70_000_000L, 4.2)
        ));


        try {
            writeCsvWithUtf8Bom(Path.of(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        appendToFile("index,name,release year, genre, rating, downloads");
        for (int i = 0; i < games.size(); i++) {
            Game g = games.get(i);
            String line = "";
            line += "\n" + (i+1) + ",";
            line +=  "\"" + g.getName() + "\"" + ",";
            line +=  g.getReleaseYear() + ",";
            line +=  "\"" + g.getGenre() + "\"" + ",";
            line +=  String.format(Locale.US, "%.2f", g.getRating()) + ",";
            line +=  g.getNumOfDownloads();
            appendToFile(line);
        }
    }

    private static void appendToFile(String line) {
        try {
            Files.writeString(Path.of(FILE_PATH), line, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeIntoFile(String text) {
        try {
            Files.writeString(Path.of(FILE_PATH), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeIntoFile(ArrayList<String> lines) {
        File file = new File(FILE_PATH);
        try {
            Files.write(file.toPath(), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeCsvWithUtf8Bom(Path file) throws IOException {
        try (OutputStream os = Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            // UTF-8 BOM
            os.write(0xEF);
            os.write(0xBB);
            os.write(0xBF);

            os.write("".getBytes(StandardCharsets.UTF_8));
        }
    }

}
