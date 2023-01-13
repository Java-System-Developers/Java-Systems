package Users;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Playground {
    public static void main(String[] args) throws IOException {
        List<List<String>> records = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv");
        UserDatabase userDatabase = new UserDatabase();

        try (CSVReader csvReader = new CSVReader(fileReader)) {

            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
//            String[][] credentials = userDatabase.getCredentials(records);
//            System.out.printf("Usernames: %s\nPasswords: %s\nUserID's: %s\n", Arrays.toString(credentials[0]), Arrays.toString(credentials[1]), Arrays.toString(credentials[2]));
        }
    }
}
