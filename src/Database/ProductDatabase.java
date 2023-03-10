package Database;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDatabase {
    public List<List<String>> Products(int choice) throws IOException{
        String gameNameWithExtension;
        String name = "hallo";
        List<List<String>> records = new ArrayList<>();

        gameNameWithExtension = getGameName(choice);
        FileReader fileReader = new FileReader("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Database\\Games\\" + gameNameWithExtension);

        try (CSVReader csvReader = new CSVReader(fileReader)) {
            String[] values;
            while ((values = csvReader.readNext()) != null){
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    public static String getGameName(int choice){
        return switch (choice) {
            case 1 -> "CSGO.csv";
            case 2 -> "DOTA 2.csv";
            default -> "";
        };
    }
}
