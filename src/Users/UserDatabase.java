package Users;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserDatabase {
    // Global Variable
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
         * Writing to CSV File
         */

        // Variables
        String name, password, randomID;
        List<List<String>> records = new ArrayList<>();

        // Input
        System.out.print("Enter Username: ");
        name = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();
        randomID = RandomStringUtils.randomNumeric(6);


        FileWriter fileWriter = new FileWriter("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv", true);
        FileReader fileReader = new FileReader("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv");

        try (CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            // Adding Header to CSV
            /*String[] header = {"Name", "Password", "ID"};
            csvWriter.writeNext(header);*/
            try (CSVReader csvReader = new CSVReader(fileReader)) {
                String[] values;
                while ((values = csvReader.readNext()) != null) {
                    records.add(Arrays.asList(values));
                }
                if (checkCredentials(records, name, password)){
                    System.out.println("You are already logged in!");
                } else {
                    System.out.println("Credentials not found, creating account.......");
                    // Adding Credentials
                    String[] credentialData = {name, password, randomID};
                    csvWriter.writeNext(credentialData);
                }
            } catch (Exception ignored) {

            }
            // Closing Writer Connection
            csvWriter.close();
        } catch (Exception ignored) {
        }
    }

    public static boolean isLoggedIn() {
        return false;
    }

    public static boolean checkCredentials(List<List<String>> records, String name, String password) {
        for (int i = 1; i < records.size() - 1; i++) {
            if (Objects.equals(records.get(1).get(0), name) && Objects.equals(records.get(i).get(1), password)) {
                return true;
            }
        }
        return false;
    }
}
