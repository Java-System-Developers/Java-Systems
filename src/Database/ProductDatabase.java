package Database;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDatabase {
    public List<List<String>> getValues() throws FileNotFoundException, IOException {
        List<List<String>> records = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Database\\Products.csv");

        try (CSVReader csvReader = new CSVReader(fileReader)) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }
}
