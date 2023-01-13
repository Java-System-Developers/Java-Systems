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
        /* Checking Credentials */

        System.out.print("Enter Username: ");
        name = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();
        randomID = RandomStringUtils.randomNumeric(6);


        FileWriter fileWriter = new FileWriter("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv", true);
        FileReader fileReader = new FileReader("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv");

        try (CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            try (CSVReader csvReader = new CSVReader(fileReader)) {
                String[] values;
                while ((values = csvReader.readNext()) != null) {
                    records.add(Arrays.asList(values));
                }
                String[][] credentials = getCredentials(records); // Dili ko sure kung unsay gamit ani karon, basta naka 2d array na ang mga credentials

                switch (checkCredentials()) {
                    case 1 -> System.out.println("Username is already taken!");
                    case 2 -> System.out.println("Password is already taken!");
                    case 3 -> System.out.println("You are already logged in!");
                    default -> {
                        // Adding Credentials
                        String[] credentialData = {name, password, randomID};
                        csvWriter.writeNext(credentialData);
                    }
                }
            } catch (Exception ignored) {

            }
            // Closing Writer Connection
            csvWriter.close();
        } catch (Exception ignored) {
        }
    }

    public static int checkCredentials() {

        return 0;
    }

    public static int checkUserNameAndPassword(List<List<String>> records, String username, String password){
        for (int i = 1; i < records.size(); i++) {
            if (Objects.equals(records.get(i).get(0), username) && Objects.equals(records.get(i).get(1), password)) {
                return 1;
            }
        }
        return 0;
    }

    public static int checkIfUserNameIsUsed(String[] userName, String name){
        for (String s : userName) {
            if (Objects.equals(s, name)) {
                System.out.println("Username is already used");
                return 1;
            }
        }
        return 0;
    }

    public static int checkIsPasswordIsUsed(String[] passwordArray, String password){
        for (String s : passwordArray){
            if (Objects.equals(s, password)){
                return 1;
            }
        }
        return 0;
    }

    public static String[][] getCredentials(List<List<String>> records){
        String[] username = new String[records.size()];
        String[] password = new String[records.size()];
        String[] userID = new String[records.size()];

        for (int i = 0; i < records.size(); i++) {
            username[i] = records.get(i).get(0);
            password[i] = records.get(i).get(1);
            userID[i] = records.get(i).get(2);
        }

        return new String[][]{username, password, userID};
    }
}
